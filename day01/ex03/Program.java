package ex03;

import ex00.Transaction;

public class Program {
    public static void main(String[] args) {
        User user1 = new User("Leonid", 500);
        //User user2 = new User("Sergey", -700, 2);
        User user3 = new User("Polina", 1000);
        User user4 = new User("Joker", 100000);
        User user5= new User("LOL", 1);

        System.out.println("id: " + user1.getIdentifier() + " | " + user1.getNameUser() + " | Balance: " + user1.getBalance());
        //System.out.println(user2);
        System.out.println("id: " + user3.getIdentifier() + " | " + user3.getNameUser() + " | Balance: " + user3.getBalance());
        System.out.println("id: " + user4.getIdentifier() + " | " + user4.getNameUser() + " | Balance: " + user4.getBalance());
        System.out.println("id: " + user5.getIdentifier() + " | " + user5.getNameUser() + " | Balance: " + user5.getBalance());

        System.out.println("\n");

    }
}