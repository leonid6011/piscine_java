package ex02;

public interface UsersList  {
    Integer defaultArrayCapacity = 10;

    void addUser(User user) throws NullPointerException;
    User getUserId(Integer id) throws UserNotFoundException;
    User getUserIndex(Integer index) throws UserNotFoundException;
    int getListSize();
}