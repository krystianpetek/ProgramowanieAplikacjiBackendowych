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

        //  string na byte
        String text2 = "";
        String text3 = text2 + "";
        byte[] ddd = text2.getBytes(StandardCharsets.UTF_8);

        // byte na string
        String sss = new String(ddd,StandardCharsets.UTF_8);
    }
}
