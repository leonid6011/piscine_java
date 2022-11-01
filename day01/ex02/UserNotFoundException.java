package ex02;

public class UserNotFoundException extends RuntimeException {
    public String toString() {
        return ("Exception: User not found!");
    }
}
