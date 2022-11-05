package edu.school21.printer.app;

import edu.school21.printer.logic.Convert;

import java.nio.file.Files;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.io.InputStream;

public class Main {
    private static char whiteSumbolColor;
    private static char blackSumbolColor;
    public static void main(String[] args) throws Exception {
        if (args.length < 2 || args[0].length() > 1 || args[1].length() > 1)	{
            throw new Exception("Invalid arguments!");
        }
        whiteSumbolColor = args[0].charAt(0);
        blackSumbolColor = args[1].charAt(0);

        InputStream inputStream =  Main.class.getResourceAsStream("/resources/it.bmp");

        Convert convert = new Convert(inputStream, whiteSumbolColor, blackSumbolColor);
        convert.print();
    }
}
