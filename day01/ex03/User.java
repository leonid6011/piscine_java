package ex03;

import ex01.UserIdsGenerator;

public class User {
    private Integer Identifier;
    private String NameUser;
    private Integer Balance;
    public static TransactionsLinkedList Transactions = new TransactionsLinkedList();

    public User(String name, Integer balance) {
        this.Identifier = UserIdsGenerator.getInstance().generateId();;
        setNameUser(name);
        setBalance(balance);
    }

    public Integer getIdentifier() { return Identifier; }
    public String getNameUser() { return NameUser; }
    public Integer getBalance() {
        return Balance;
    }

    public Transaction[] getTransactionsArray() {
        return Transactions.toArray();
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
