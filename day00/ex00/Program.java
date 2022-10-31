package ex00;

public class Program {
    public static void main(String[] args) {
        int result = 0;
        int nbr = 479598;

        result = result + (nbr / 100000);
        nbr %= 100000;
        result = result + (nbr / 10000);
        nbr %= 10000;
        result = result + (nbr / 1000);
        nbr %= 1000;
        result = result + (nbr / 100);
        nbr %= 100;
        result = result + (nbr / 10);
        nbr %= 10;
        result += nbr;
        System.out.println(result);
    }
}
