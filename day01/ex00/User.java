package ex00;

public class User {
    private Integer Identifier;
    private String NameUser;
    private Integer Balance;

    public User(String name, Integer balance, Integer ID) {
        this.Identifier = ID;
        this.NameUser = name;
        this.Balance = balance;
    }

    public Integer getIdentifier() {
        return Identifier;
    }
    public String getNameUser() {
        return NameUser;
    }
    public Integer getBalance() {
        return Balance;
    }

    public boolean setNameUser(String name) {
        if (name.length() > 0) {
            NameUser = name;
            return true;
        }
        System.err.println("Error: Invalid name!");
        return false;
    }

    public boolean setBalance(Integer balance) {
        if (balance >= 0) {
            Balance = balance;
            return true;
        }
        System.err.println("Error: Invalid balance!");
        return false;
    }
}
