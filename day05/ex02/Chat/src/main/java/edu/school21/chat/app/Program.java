package edu.school21.chat.app;

import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;
import edu.school21.chat.repositories.MessagesRepository;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Program {
    public static void main(String[] args) throws SQLException {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl("jdbc:postgresql://localhost:5432/day05ex01");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres");

        Statement statementUser = dataSource.getConnection().createStatement();

        ResultSet userSet = statementUser.executeQuery("SELECT * FROM users WHERE id = " + 1);
        userSet.next();

        Statement statementRoom = dataSource.getConnection().createStatement();

        ResultSet roomSet = statementRoom.executeQuery("SELECT * FROM rooms WHERE id = " + 1);
        roomSet.next();

        User user = new User(userSet.getInt("id"), userSet.getString("login"), userSet.getString("password"), new ArrayList<>(), new ArrayList<>());
        userSet.close();

        Chatroom room = new Chatroom(roomSet.getInt("id"), roomSet.getString("name"), user, new ArrayList<>());
        roomSet.close();

        MessagesRepository messagesRepository = new MessagesRepositoryJdbcImpl(dataSource);

        Message message = new Message(0, user, room, "Hello! I am here! LOL", null);
        messagesRepository.save(message);

        User fakeUser = new User(22340, "lol", "lol!", new ArrayList<>(), new ArrayList<>());

        Message messageTest = new Message(0, fakeUser, room, "LOL", null);
        messagesRepository.save(messageTest);
    }
}
