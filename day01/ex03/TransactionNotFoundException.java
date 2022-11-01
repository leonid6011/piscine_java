package ex03;


public class TransactionNotFoundException extends RuntimeException {

    public String toString() {
        return ("Exception: Transaction not found!");
    }

}