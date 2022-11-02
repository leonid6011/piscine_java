package ex03;

import java.util.UUID;

public class Program {

    public static void printTransaction(Transaction elem) {
        System.out.println(elem + " " + elem.getIdentifier()  + " " +  elem.getCategory() + " " + elem.getAmount());
    }
    public static void main(String[] args) {
        User leonid = new User("Leonid", 500);
        User joker = new User("Joker", 100000);

        System.out.println("id: " + leonid.getIdentifier() + " | " + leonid.getNameUser() + " | Balance: " + leonid.getBalance());
        System.out.println("id: " + joker.getIdentifier() + " | " + joker.getNameUser() + " | Balance: " + joker.getBalance());

        TransactionsLinkedList listTransactions = new TransactionsLinkedList();

        Transaction transaction1 = new Transaction(joker, leonid, 1000);
        printTransaction(transaction1);

        Transaction transaction2 = new Transaction(joker, leonid, 600);
        printTransaction(transaction2);

        Transaction transaction3 = new Transaction(joker, leonid, 1);
        printTransaction(transaction3);

        Transaction transaction4 = new Transaction(joker, leonid, 50);
        printTransaction(transaction4);

        System.out.println("\n================LIST===================\n");

        listTransactions.addTransaction(transaction1);
        listTransactions.addTransaction(transaction2);
        listTransactions.addTransaction(transaction3);
        listTransactions.addTransaction(transaction4);

        Transaction[] arrayTransaction = listTransactions.toArray();
        for (Transaction elem : arrayTransaction){
            printTransaction(elem);
        }

        System.out.println("\n================DELETE_TRANSACTION=====================");
        listTransactions.deleteTransaction(transaction1.getIdentifier());
        Transaction[] arrayTransaction2 = listTransactions.toArray();
        System.out.println("=======================================================");

        System.out.println("");

        for (Transaction elem : arrayTransaction2){
            printTransaction(elem);
        }

        System.out.println("\n================DELETE_TRANSACTION=====================");
        listTransactions.deleteTransaction(transaction4.getIdentifier());
        Transaction[] arrayTransaction3 = listTransactions.toArray();
        System.out.println("=======================================================");

        System.out.println("");

        for (Transaction elem : arrayTransaction3){
            printTransaction(elem);
        }

//        System.out.println("\n================DELETE_TRANSACTION_FALSE===================");
//        listTransactions.deleteTransaction(UUID.randomUUID());
//        Transaction[] arrayTransaction1 = listTransactions.toArray();
//        System.out.println("=============================================================");

    }
}