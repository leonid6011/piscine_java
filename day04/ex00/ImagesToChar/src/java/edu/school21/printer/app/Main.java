package edu.school21.printer.app;

import edu.school21.printer.logic.Convert;

import java.nio.file.Files;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;

public class Main {
    private static char whiteSumbolColor;
    private static char blackSumbolColor;
    public static void main(String[] args) throws Exception {
        if (args.length < 3 || args[0].length() > 1 || args[1].length() > 1)	{
            throw new Exception("Invalid arguments!");
        }
        whiteSumbolColor = args[0].charAt(0);
        blackSumbolColor = args[1].charAt(0);

        File file = new File(args[2]);

        if (!file.isFile())
            throw new Exception("Invalid Path!");

        Convert convert = new Convert(file, whiteSumbolColor, blackSumbolColor);
        convert.print();
    }
}
