package ex02;

import java.util.Scanner;

public class Program {
    public static int sumNbrFun(int nbr) {
        int sum = 0;
        int oneNbr;
        while (nbr != 0) {
            oneNbr = nbr % 10;
            sum += oneNbr;
            nbr /= 10;
        }
        return sum;
    }

    public static boolean checkPrimeNbr(int sumNbr) {
        boolean nbrIsPrime = true;
        int i = 2;
        for (; (i * i) <= sumNbr; i++) {
            if (sumNbr % i == 0) {
                nbrIsPrime = false;
                break;
            }
        }
        return (nbrIsPrime);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        while (scanner.hasNext()) {
            int nbr = scanner.nextInt();
            if (nbr == 42) {
                System.out.println("Count of coffee-request - " + count);
                return;
            }
            int sumNbr = sumNbrFun(nbr);
            if (checkPrimeNbr(sumNbr)){
                count++;
            }
        }
        scanner.close();
    }
}
