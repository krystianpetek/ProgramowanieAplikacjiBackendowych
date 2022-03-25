package Przyklad04;

import java.util.*;

public class Main {
    public static void main(String[] args)
    {

        Map<String, String> map1 = new HashMap<>();
        Map<String, String> map2 = new TreeMap<>();

        map1.put("A", "Text 1");
        map1.put("B", "Text 2");
        map1.put("C", "Text 3");

        String a = map1.get("A"); // przypisanie wartości klucza "A" do stringa

        if(map1.containsKey("A")) // jesli zawiera klucz "A", to wypisz do konsoli
        {
            System.out.println(map1.get("A"));
        }

        // polimorfizm
        Map<String, String> map = map1; // do map, przypisanie HashMapy
        map = map2; // do map przypisanie TreeMapy

        map2.forEach((key,value) -> {
            // iteracja map2
        });

        Collection<String> values = map.values(); // przypisanie do kolekcji która implementuje Iterable
        for(String el:values)
        {
            // iteracja w forze
        }

        // jesli zabraknie miejsca initialCapacity: 100, to ArrayLista jest zwiększana o 100
        List<String> list = new ArrayList<>(100);
        List<String> list2 = new LinkedList<>();
        list.add("");
        list2.add("222");
        list.add("333");

        // set, struktura do pracy bez duplikatów
        Set<String> set1 = new HashSet<>(); // tworzony gdy będziemy często odczytywać
        Set<String> set2 = new TreeSet<>(); //
        Set<String> set3 = new LinkedHashSet<>();

        boolean b1 = set1.add("aaa"); // funkcja zwroci info czy udalo sie dodac aaa do set1
        boolean b2 = set1.add("aaa"); // tutaj funkcja zwroci false, bo to duplikat
    }
}
