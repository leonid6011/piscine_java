package edu.school21.chat.repositories;

import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;

//import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.Optional;

public class MessagesRepositoryJdbcImpl implements MessagesRepository{
    private HikariDataSource data;

    public MessagesRepositoryJdbcImpl(HikariDataSource data) {
        this.data = data;
    }

    @Override
    public Optional<Message> findById(Long id) throws SQLException {
        Optional<Message> optionalMessage;
        Statement statementMessage = data.getConnection().createStatement();
        Statement statementAuthor = data.getConnection().createStatement();
        Statement statementRoom = data.getConnection().createStatement();
        Statement statementOwner = data.getConnection().createStatement();

        ResultSet messageSet = statementMessage.executeQuery("SELECT * FROM messages WHERE id = " + id);
        messageSet.next();

        ResultSet authorSet = statementAuthor.executeQuery("SELECT * FROM users WHERE id = " + messageSet.getInt("author"));
        authorSet.next();

        User author = new User(
                authorSet.getInt("id"),
                authorSet.getString("login"),
                authorSet.getString("password"),
                new ArrayList<>(),
                new ArrayList<>()
        );

        ResultSet roomSet = statementRoom.executeQuery("SELECT * FROM rooms WHERE id = " + messageSet.getInt("room"));
        roomSet.next();

        ResultSet ownerSet = statementOwner.executeQuery("SELECT * FROM users WHERE id = " + roomSet.getInt("owner_id"));
        ownerSet.next();

        User owner = new User(
                ownerSet.getInt("id"),
                ownerSet.getString("login"),
                ownerSet.getString("password"),
                new ArrayList<>(),
                new ArrayList<>()
        );

        Chatroom room = new Chatroom(
                roomSet.getInt("id"),
                roomSet.getString("name"),
                owner,
                null
        );

        optionalMessage = Optional.of(
                new Message(
                        messageSet.getInt("id"),
                        author,
                        room,
                        messageSet.getString("text"),
                        messageSet.getTimestamp("timestamp").toLocalDateTime()
                )
        );
        messageSet.close();
        authorSet.close();
        roomSet.close();
        ownerSet.close();
        return optionalMessage;
    }

    @Override
    public void save(Message message) throws NotSavedSubEntityException, SQLException {
        String insert = "INSERT INTO messages(author, room, text) VALUES (" +
                message.getRoom().getId() + ", " +
                message.getAuthor().getId() + ", '" +
                message.getText() + "')";
        PreparedStatement preparedStatement = data.getConnection().prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
        try {
            preparedStatement.execute();
            ResultSet messageSet = preparedStatement.getGeneratedKeys();
            messageSet.next();
            message.setId(messageSet.getInt("id"));
        } catch (SQLException e) {
            throw new NotSavedSubEntityException();
        }
    }
}