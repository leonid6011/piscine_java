package ex01;

import java.io.*;
import java.util.*;

public class Program {
    public static String mathFun(int[] arrayFirst, int[] arraySecond) {
        double Numerator = 0;
        double sumOne = 0;
        double sumTwo = 0;
        for (int i = 0; i <  arrayFirst.length; i++)
        {
            Numerator =  Numerator + arrayFirst[i] * arraySecond[i];
            sumOne = sumOne + arrayFirst[i] *  arrayFirst[i];
            sumTwo = sumTwo + arraySecond[i] * arraySecond[i];
        }
        double Denominator = (Math.sqrt(sumOne) * Math.sqrt(sumTwo));
        double Similarity = Numerator / Denominator;
        String result = String.format("Similarity = %.2f", ((int)(Similarity * 100) / 100.0));
        return result;
    }
    public static void creatDictionary(List<String> list) throws IOException
    {
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("src/ex01/dictionary.txt")))) {
            for (String str : list)
                writer.write(str + " ");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws IOException {

        Set<String> set = new HashSet<>();
        List<String> list = null;

        if (args.length != 2)
        {
            System.out.println("Bad arguments!");
        }
        try
        {
            BufferedReader bReaderFirst = new BufferedReader(new InputStreamReader(new FileInputStream(args[0])));
            BufferedReader bReaderSecond = new BufferedReader(new InputStreamReader(new FileInputStream(args[1])));

            while (bReaderFirst.ready())
            {
                String[] arr = bReaderFirst.readLine().split(" ");
                set.addAll(Arrays.asList(arr));
            }

            while (bReaderSecond.ready()){
                String[] arr = bReaderSecond.readLine().split(" ");
                set.addAll(Arrays.asList(arr));
            }

        }
        catch (IOException e) {
            System.out.println("Bad arguments!");
        }
        int [] arrayFirst= null;
        int [] arraySecond = null;
        try
        {
            BufferedReader bReaderFirst = new BufferedReader(new InputStreamReader(new FileInputStream(args[0])));
            BufferedReader  bReaderSecond = new BufferedReader(new InputStreamReader(new FileInputStream(args[1])));
            list = new ArrayList<>(set);
            arrayFirst = new int[set.size()];
            arraySecond = new int[set.size()];
            while (bReaderFirst.ready())
            {
                String[] arr = bReaderFirst.readLine().split(" ");
                for (String s : arr){
                    if (list.contains(s)){
                        int index = list.indexOf(s);
                        arrayFirst[index]++;
                    }
                }
            }
            while (bReaderSecond.ready())
            {
                String[] arr =  bReaderSecond.readLine().split(" ");
                for (String s : arr) {
                    if (list.contains(s)) {
                        int index = list.indexOf(s);
                        arraySecond[index]++;
                    }
                }
            }
        }
        catch (IOException e) {
            System.out.println("Bad arguments!");
        }
        creatDictionary(list);
        String result = mathFun(arrayFirst, arraySecond);
        System.out.println(result);
    }
}