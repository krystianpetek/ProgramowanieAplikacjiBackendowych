package Dodatkowe3;

import java.util.HashMap;

public class Main {
    public static void main(String[] x) {
        String[] lista = new String[]{"a", "a", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "k", "k", "k", "l", "m", "n", "o", "p", "r", "s", "t", "u", "w", "x", "y", "z", "z"};
        HashMap<String, Integer> hashMapa = new HashMap<String, Integer>();
        for (int i = 0; i < lista.length; i++) {
            if (hashMapa.containsKey(lista[i])) {
                Integer ilosc = hashMapa.get(lista[i]);
                ilosc++;
                hashMapa.replace(lista[i], ilosc);
            } else {
                hashMapa.put(lista[i], 1);
            }
        }
        System.out.println(hashMapa);
    }
}
