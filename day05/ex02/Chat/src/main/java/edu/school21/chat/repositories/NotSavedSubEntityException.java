package edu.school21.chat.repositories;

public class NotSavedSubEntityException extends RuntimeException {
    public String toString() {
        return ("Dont saved!");
    }
}
