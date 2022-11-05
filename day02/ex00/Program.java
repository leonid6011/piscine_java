package ex00;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Program {

    private static final String PathSignature = "src/ex00/signatures.txt";
    private static final String resultOutput = "src/ex00/result.txt";

    public static int[] getBytes(int length, FileInputStream fileScanner) throws IOException {
        int[] bytes = new int[length];

        for (int i = 0; i < length; i++) {
            bytes[i] = fileScanner.read();
        }
        return (bytes);
    }

    public static boolean checkBytes(int[] key, int[] file)
    {
        for (int i = 0; i < key.length; i++)
        {
            if (key[i] != file[i])
                return false;
        }
        return true;
    }
    public static void main(String[] args) throws IOException {

        Parser signature = new Parser(new File(PathSignature));
        Map<int[], String> mapSignatures = signature.parseKeyValues();
        Scanner scanner = new Scanner(System.in);
        List<String> result = new ArrayList<>();
        try
        {
            String input = scanner.nextLine();
            while (!input.equals("42")) {
                boolean flag = false;
                for (int[] key : mapSignatures.keySet())
                {
                    FileInputStream fileScanner = new FileInputStream(input);
                    int[] fileContent = getBytes(key.length, fileScanner);
                    fileScanner.close();
                    if (checkBytes(key, fileContent)) {
                        result.add(mapSignatures.get(key));
                        flag = true;
                        break;
                    }

                }
                if (flag)
                    System.out.println("PROCESSED");
                else
                    System.out.println("UNDEFINED");
                input = scanner.nextLine();
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        try
        {
            FileOutputStream outputStream = new FileOutputStream(resultOutput);
            for (String line : result) {
                outputStream.write((line + '\n').getBytes(StandardCharsets.UTF_8));
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}