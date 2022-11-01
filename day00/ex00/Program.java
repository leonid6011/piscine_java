package ex00;

public class Program {
    public static void main(String[] args) {
        int result = 0;
        int number = 479598;

        result = result + (number / 100000);
        number %= 100000;
        result = result + (number / 10000);
        number %= 10000;
        result = result + (number / 1000);
        number %= 1000;
        result = result + (number / 100);
        number %= 100;
        result = result + (number / 10);
        number %= 10;
        result += number;
        System.out.println(result);
    }
}
