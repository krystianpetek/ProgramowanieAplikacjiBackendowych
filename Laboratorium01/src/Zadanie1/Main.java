package Zadanie1;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws IOException {
//        FileInputStream inputStream = new FileInputStream("file.txt");
//        InputStreamReader readerStream = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
//        char[] znaki = new char[20];
//        readerStream.read(znaki,0,znaki.length);
//        System.out.println(znaki);

        try {
            byte[] data = Files.readAllBytes(Paths.get("file.txt"));
            String text = new String(data, StandardCharsets.UTF_8);
            System.out.println(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
