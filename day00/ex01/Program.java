package ex01;

import java.util.Scanner;

public class Program {

    public static void checkPrimeNbr(int nbr) {
        boolean nbrIsPrime = true;
        int i = 2;
        for (; (i * i) <= nbr; i++) {
            if (nbr % i == 0) {
                nbrIsPrime = false;
                break;
            }
        }
        if (nbrIsPrime)
            System.out.println("true " + (i - 1));
        else
            System.out.println("false " + (i - 1));
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) {
            System.err.println("IllegalArgument");
            System.exit(-1);
        }
        int nbr = scanner.nextInt();
        if (nbr < 1) {
            System.err.println("IllegalArgument");
            System.exit(-1);
        }
        checkPrimeNbr(nbr);
        scanner.close();
    }
}


