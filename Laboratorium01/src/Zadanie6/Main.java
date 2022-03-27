package Zadanie6;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        try {
            byte[] data = Files.readAllBytes(Paths.get("multipleLineFile.txt"));
            String text = new String(data, StandardCharsets.UTF_8);
            var podzielone = text.split("\r\n");

            for (int i = 0; i < podzielone.length; i++) {
                System.out.println(i + 1 + ". " + podzielone[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
