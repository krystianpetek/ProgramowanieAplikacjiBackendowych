package Zadanie2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException
    {
        FileOutputStream streamOutput = new FileOutputStream("output.txt");
        OutputStreamWriter writer = new OutputStreamWriter(streamOutput);
        Scanner scanner = new Scanner(System.in);
        String linia = scanner.nextLine();
        writer.write(linia);
        writer.flush();
    }
}
