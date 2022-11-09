package edu.school21.numbers;

public class NumberWorker {
        public boolean isPrime(int number) {
        if (number < 2)
            throw new IllegalNumberException();

        boolean nbrIsPrime;
        nbrIsPrime = true;
        int i = 2;
        for (; (i * i) <= number; i++) {
            if (number % i == 0) {
                nbrIsPrime = false;
                break;
            }
        }
        return (nbrIsPrime);
    }

        public int  digitsSum(int number) {
        int sum = 0;
        int oneNbr;
        while (number != 0) {
            oneNbr = number % 10;
            sum += oneNbr;
            number /= 10;
        }
        return sum;
    }
}

class IllegalNumberException extends RuntimeException{
    IllegalNumberException() {
        System.err.println("<<Exception: Illegal number exception!>>");
    }
}