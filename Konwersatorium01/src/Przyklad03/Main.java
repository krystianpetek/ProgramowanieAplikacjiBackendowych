package Przyklad03;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        // zwraca false, bo objekty sa porownywane po referencajch a typy proste po wartosciach
        // dodanie equals
        Object o1 = new Object();
        Object o2 = new Object();
        boolean check = o1.equals(o2);
        System.out.println(check);

        // interfejs funkcjonalny, żaden typ generyczny nie moze przyjąć małego int'a, tylko Integer
        // Integer to klasa a int to typ podstawowy całkowity
        Function<Integer, Integer> fun = (a) -> 2 * 2;
        int wynik = fun.apply(1);
        System.out.println(wynik);

        Action fun2 = (a, b) -> a + b;
        double wynik2 = fun2.sum(5, 8);
        System.out.println(wynik2);

        // Mały int nei może być null, a Integer klasowy może być nullem, to samo z Long'iem
        int x = 0;
        Integer X = null;
    }

    @FunctionalInterface
    interface Action {
        double sum(double a, double b);
    }

    public class UserEntity {
        Long id;
        String name;
    }
}
