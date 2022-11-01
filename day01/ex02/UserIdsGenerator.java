package ex02;

public class UserIdsGenerator {
    private static UserIdsGenerator instance;
    private static int id = 0;

    private UserIdsGenerator() {}

    public static UserIdsGenerator getInstance() {
        if (instance == null) {
            instance = new UserIdsGenerator();
        }
        return instance;
    }
    public static int generateId()	{
        id++;
        return (id);
    }
}
