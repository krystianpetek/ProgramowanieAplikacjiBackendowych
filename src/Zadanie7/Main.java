package Zadanie7;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        Uzytkownik uzytkownik = new Uzytkownik("Krystian", "Petek", 23);
        ObjectMapper objectMapper = new ObjectMapper();
        String uzytkownikJson = objectMapper.writeValueAsString(uzytkownik);
        System.out.println(uzytkownikJson);
    }
}
