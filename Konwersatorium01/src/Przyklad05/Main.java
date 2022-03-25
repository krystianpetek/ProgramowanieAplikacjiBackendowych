package Przyklad05;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args)
    {
        // java dostarcza duzo rzeczy
        java.math.BigInteger bigInteger;
        Integer a=1, b = 2;
        int x = a ^ b; // - xor 2 liczb

        //   AND
        //   1001
        // & 0001
        //   0001

        //   OR
        //   1001
        // | 0001
        //   1001

        //   NOT
        //   1001
        // ! 0110
        int negacja = ~(-6);
        System.out.println(negacja);

        //  &  <-- binary AND
//  |  <-- binary OR
//  ^  <-- binary XOR
//  ~  <-- binary NOT


//    BIN    DEC
//
//    1001   9
//  & 0001   1
//    ----
//    0001   1


//    BIN    DEC
//
//    1001   9
//  | 0001   1
//    ----
//    1001   1


//    BIN    DEC
//
//    1001   9
//  ^ 0001   1
//    ----
//    1000   9


//    BIN    DEC
//
//  ~ 1001   9
//    ----
//    0110   6

        //  string na byte
        String text2 = "";
        String text3 = text2 + "";
        String text = "Some text here ...";
        byte[] bytes = text.getBytes(StandardCharsets.UTF_8);  // [83, 111, 109, 101, 32, 116, 101, 120, 116, 32, 104, 101, 114, 101, 32, 46, 46, 46]

        // byte na string
        String textZbyte = new String(bytes, StandardCharsets.UTF_8);  // Some text here ...

    }
}
