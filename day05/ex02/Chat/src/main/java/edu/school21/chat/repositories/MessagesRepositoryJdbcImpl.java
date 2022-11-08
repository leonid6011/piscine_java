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
    private HikariDataSource ds;

    public MessagesRepositoryJdbcImpl(HikariDataSource ds) {
        this.ds = ds;
    }

    @Override
    public Optional<Message> findById(Long id) throws SQLException {
        Connection connection = ds.getConnection();

        Optional<Message> optionalMessage;

        Statement statementMessage = connection.createStatement();

        String query = "SELECT * FROM messages WHERE id = ";

        ResultSet messageSet = statementMessage.executeQuery(query + id);
        messageSet.next();

        User author = new User(1, "LOL", "lol123", null, null);
        Chatroom chatroom = new Chatroom(1, "some chat", new User(1, "owner", "owner123", null, null), null);

        optionalMessage = Optional.of(new Message(messageSet.getInt("id"), author, chatroom, messageSet.getString("text"), messageSet.getTimestamp("timestamp").toLocalDateTime()));

        messageSet.close();
        return optionalMessage;
    }

    @Override
    public void save(Message message) throws NotSavedSubEntityException, SQLException {
        String insert = "INSERT INTO messages(author, room, text) VALUES (" +
                message.getRoom().getId() + ", " +
                message.getAuthor().getId() + ", '" +
                message.getText() + "')";
        PreparedStatement preparedStatement = ds.getConnection().prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
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