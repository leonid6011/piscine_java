package edu.school21.chat.repositories;

import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

public class MessagesRepositoryJdbcImpl implements MessagesRepository{
    private HikariDataSource ds;

    public MessagesRepositoryJdbcImpl(HikariDataSource data) {
        this.ds = data;
    }

    @Override
    public Optional<Message> findById(Long id) throws SQLException {

        Optional<Message> optionalMessage;

        Statement statementMessage = ds.getConnection().createStatement();
        Statement statementAuthor = ds.getConnection().createStatement();
        Statement statementRoom = ds.getConnection().createStatement();
        Statement statementOwner = ds.getConnection().createStatement();

        ResultSet messageSet = statementMessage.executeQuery("SELECT * FROM messages WHERE id = " + id);
        messageSet.next();

        ResultSet authorSet = statementAuthor.executeQuery("SELECT * FROM users WHERE id = " + messageSet.getInt("author"));
        authorSet.next();

        User author = new User(authorSet.getInt("id"), authorSet.getString("login"), authorSet.getString("password"), null, null);

        ResultSet roomSet = statementRoom.executeQuery("SELECT * FROM rooms WHERE id = " + messageSet.getInt("room"));
        roomSet.next();

        ResultSet ownerSet = statementOwner.executeQuery("SELECT * FROM users WHERE id = " + roomSet.getInt("owner_id"));
        ownerSet.next();

        User owner = new User(ownerSet.getInt("id"), ownerSet.getString("login"), ownerSet.getString("password"), null, null);

        Chatroom room = new Chatroom(roomSet.getInt("id"), roomSet.getString("name"), owner, null);

        optionalMessage = Optional.of(new Message(messageSet.getInt("id"), author, room, messageSet.getString("text"), messageSet.getTimestamp("timestamp").toLocalDateTime()));
        messageSet.close();
        authorSet.close();
        roomSet.close();
        ownerSet.close();
        return optionalMessage;
    }
}