package edu.school21.chat.models;

import java.util.List;

public class User {
    private int             id;
    private String          login;
    private String          password;
    private List<Chatroom>  createdRooms;
    private List<Chatroom>  socializesRooms;

    public User(int id, String login, String password, List<Chatroom> createdRooms, List<Chatroom> socializesRooms) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.createdRooms = createdRooms;
        this. socializesRooms =  socializesRooms;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Chatroom> getCreatedRooms() {
        return createdRooms;
    }

    public void setCreatedRooms(List<Chatroom> createdRooms) {
        this.createdRooms = createdRooms;
    }

    public List<Chatroom> getSocializesRooms() {
        return  socializesRooms;
    }

    public void setSocializesRooms(List<Chatroom> socializesRooms) {
        this.socializesRooms =  socializesRooms;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", createdRooms=" + createdRooms +
                ", joinedRooms=" + socializesRooms +
                '}';
    }

    @Override
    public boolean equals(Object user) {
        return super.equals(user);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
