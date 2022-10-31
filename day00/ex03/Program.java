package ex03;

import java.util.Scanner;
public class Program {
    public static void checkStr(int day, String argumentStrWeek) {
        String week = "Week ";
        String weekNbr;
        weekNbr = week + day;
        if (!argumentStrWeek.equals(weekNbr)) {
            System.out.println("IllegalArgument");
            System.exit(-1);
        }
    }

    public static int findMinGrade(Scanner scanner) {
        int minGradeWeek = 9;
        for (int i = 0; i < 5; i++) {
            int grade = scanner.nextInt();
            if (grade < minGradeWeek)
                minGradeWeek = grade;
        }
        return minGradeWeek;
    }

    public static long creatData(int minGradeWeek, int day) {
        long dataTmp = minGradeWeek;
        for (int i = 1; i < day; i++) {
            dataTmp *= 10;
        }
        return dataTmp;
    }

    public static void printData(long data) {
        long oneNbr;
        for (int day = 1; day <= 18; day++) {
            oneNbr = data % 10;
            if (oneNbr == 0) {
                break;
            }
            System.out.print("Week " + day + " ");
            for (int i = 0; i < oneNbr; i++){
                System.out.print("=");
            }
            System.out.println(">");
            data /= 10;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String argumentStrWeek;

        int day = 1;
        long data = 0;
        while (scanner.hasNext()) {
            argumentStrWeek = scanner.nextLine();
            if (argumentStrWeek.equals("42"))
                break;
            checkStr(day, argumentStrWeek);
            int minGradeWeek = findMinGrade(scanner);
            scanner.nextLine();
            data += creatData(minGradeWeek, day);
            day++;
        }
        printData(data);
    }
}
