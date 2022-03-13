import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main4 {
    public static void main(String[] args) throws IOException {

        FileInputStream stream = new FileInputStream("Laboratorium01/src/file.txt");
        InputStreamReader reader = new InputStreamReader(stream, StandardCharsets.UTF_8);
        char[] characters = new char[20];
        reader.read(characters, 0, characters.length);
        System.out.println(characters);

        try {
            byte[] data = Files.readAllBytes(Paths.get("Laboratorium01/src/file.txt"));
            String text = new String(data, StandardCharsets.UTF_8);
            System.out.println(text);
        } catch (IOException e) {
            e.printStackTrace( );
        }
    }
}
