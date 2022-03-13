package WYKLADY;

import java.sql.Array;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.*;
import java.util.function.Function;

public class Main2 {
    public static void main(String a[]) {
        Map<String, String> map1 = new HashMap<>();
        Map<String, String> map2 = new TreeMap<>();

        Map<String, String> map = map1;
        map.put("A", "Text 1");
        map.put("B", "Text 2");
        map.put("C", "Text 3");

        String aa = map1.get("A");

        if(map.containsKey("A"))
        {

        }
        map2.forEach((key,value) -> {

        });
        Collection<String> values = map.values();
        for(String el:values)
        {

        }
        List<String> list = new ArrayList<>(100);
        List<String> list2 = new LinkedList<>();
        list.add("");
        list2.add("222");
        list.add("333");

        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new TreeSet<>();
        Set<String> set3 = new LinkedHashSet<>();

        boolean b1 = set1.add("aaa");
        boolean b2 = set1.add("aaa");

        // java dostarcza duzo rzeczy
        java.math.BigInteger bi;

        //a ^ b // - xor 2 liczb
        // 1001
        // 0001
        // 0001




    }
}
