package ex00;

public class User {
    private Integer Identifier;
    private String NameUser;
    private Integer Balance;

    public User(String name, Integer balance, Integer ID) {
        this.Identifier = ID;
        setNameUser(name);
        setBalance(balance);
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

    public void setNameUser(String name) {
        if (name.length() > 0) {
            NameUser = name;
            return;
        }
        System.err.println("Error: Invalid name!");
    }

    public void setBalance(Integer balance) {
        if (balance >= 0) {
            Balance = balance;
            return;
        }
        System.err.println("Error: Invalid balance!");
    }
}
