package ex00;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Parser {

    private final Scanner scanner;

    public Parser(File signatures) throws FileNotFoundException {
        this.scanner = new Scanner(signatures);
    }

    private String readLine() {
        if (scanner.hasNextLine())
            return (scanner.nextLine());
        return ("");
    }
    private int[] convertKeyToBytes(String key) {
        int count = countBytes(key);
        int[] ret = new int[count];

        Scanner keyParser = new Scanner(key).useRadix(16);

        for (int i = 0; i < count; i++)
            ret[i] = keyParser.nextShort();
        return (ret);
    }

    private int countBytes(String key) {
        int count = 0;

        Scanner keyParser = new Scanner(key).useRadix(16);

        while (keyParser.hasNextShort()) {
            keyParser.nextShort();
            count++;
        }
        keyParser.close();
        return (count);
    }

    public Map<int[], String> parseKeyValues() {
        Map<int[], String> mapData = new HashMap<>();
        String line = this.readLine();
        while (!line.isEmpty()) {
            int[] key = convertKeyToBytes(line.substring(line.indexOf(",") + 2));
            String value = line.substring(0, line.indexOf(","));
            if (key.length > 0 && !value.isEmpty()) {
                mapData.put(key, value);
            }
            line = this.readLine();
        }
        return (mapData);
    }
}