package ex00;

public class Program {
    public static void main(String[] args) {
        User user1 = new User("Leonid", 500, 1);
        //User user2 = new User("Sergey", -700, 2);
        User user3 = new User("Polina", 1000, 3);
        User user4 = new User("Joker", 100000, 3);

        System.out.println(user1 + " | " + user1.getNameUser() + " | Balance: " + user1.getBalance());
        //System.out.println(user2);
        System.out.println(user3 + " | " + user3.getNameUser() + " | Balance: " + user3.getBalance());
        System.out.println(user4 + " | " + user4.getNameUser() + " | Balance: " + user4.getBalance());

        System.out.println("\n");

        Transaction transaction1 = new Transaction(user1, user3, 500);
        System.out.println("transaction1: " + transaction1 + " " + transaction1.getIdentifier()  + " " +  transaction1.getCategory());
        System.out.println(user1 + " | " + user1.getNameUser() + " | Balance: " + user1.getBalance());
        System.out.println(user3 + " | " + user3.getNameUser() + " | Balance: " + user3.getBalance());

        System.out.println("\n");

        Transaction transaction2 = new Transaction(user1, user4, -100000);
        System.out.println("transaction2: " + transaction2 + " " + transaction2.getIdentifier()  + " " +  transaction2.getCategory());
        System.out.println(user4 + " | " + user4.getNameUser() + " | Balance: " + user4.getBalance());
        System.out.println(user1 + " | " + user1.getNameUser() + " | Balance: " + user1.getBalance());
    }
}