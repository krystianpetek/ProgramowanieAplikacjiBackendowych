package Zadanie8;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String json = "{\"imie\":\"Krystian\",\"nazwisko\":\"Petek\",\"wiek\":23}";
        ObjectMapper objectMapper = new ObjectMapper();

        Uzytkownik uzytkownik = objectMapper.readValue(json, Uzytkownik.class);

        System.out.print(uzytkownik.getImie() + " ");
        System.out.print(uzytkownik.getNazwisko() + " ");
        System.out.print(uzytkownik.getWiek());
    }
}
