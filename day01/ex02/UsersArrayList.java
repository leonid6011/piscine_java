package ex02;

public class UsersArrayList implements UsersList {
    private static final int arrayCapacity = 10;
    private User[] users;
    private int sizeUserArr;
    private void increaseUsers() {
        User[] tmp = new User[users.length + arrayCapacity];
        for (int i = 0; i <= sizeUserArr; i++) {
            tmp[i] = users[i];
        }
        users = tmp;
    }

    public UsersArrayList() {
        sizeUserArr = 0;
        users = new User[arrayCapacity];
    }
    public void addUser(User user) throws NullPointerException {
        if (sizeUserArr == arrayCapacity - 1) {
            increaseUsers();
        }
        if (user != null) {
            users[sizeUserArr] = user;
            sizeUserArr++;
        }
        else {
            throw new NullPointerException();
        }
    }

    public User getUserId(Integer id) throws UserNotFoundException {
        for (int i = 0; i < sizeUserArr; i++) {
            if (users[i].getIdentifier().equals(id))
                return  (users[i]);
        }
        throw new UserNotFoundException();
    }

    public User getUserIndex(Integer index) throws UserNotFoundException, ArrayIndexOutOfBoundsException {
        if (index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        else if (users[index] == null) {
            throw new UserNotFoundException();
        }
        return (users[index]);
    }

    public int getListSize() {
        return sizeUserArr;
    }

}
