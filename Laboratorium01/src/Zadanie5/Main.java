package Zadanie5;

import java.sql.Time;
import java.time.LocalTime;
import java.util.Date;
import java.util.TimeZone;

public class Main {
    public static void main(String[] args){
        LocalTime time = LocalTime.now();
        System.out.println("Czas lokalny: " + time);

        Date now = new Date();
        TimeZone.setDefault(TimeZone.getTimeZone("GMT"));
        System.out.println("Czas globalny: " + now);
    }
}
