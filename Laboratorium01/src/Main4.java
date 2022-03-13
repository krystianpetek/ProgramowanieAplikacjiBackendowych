import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main4 {
    public static void main(String[] args) throws IOException {
        FileInputStream stream = new FileInputStream("Laboratorium01/file.txt");
        InputStreamReader reader = new InputStreamReader(stream);

        char[] characters = new char[100];
        reader.read(characters, 0, characters.length);

        System.out.println();

//        try {
//            byte[] data = Files.readAllBytes(Paths.get("file.txt"));
//            String text = new String(data, StandardCharsets.UTF_8);
//            System.out.println(text);
//        } catch (IOException e) {
//            e.printStackTrace( );
//        }
    }
}
