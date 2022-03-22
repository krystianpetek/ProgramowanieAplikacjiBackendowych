package WYKLADY;

import javax.swing.*;
import java.util.function.Function;

public class Main1 {
    public static void main(String args[]){
        System.out.println("test!");
        byte b = 1;
        short s = 1;
        int i = 1;
        long l = 1l;
        float f = 1.0f;
        double d = 1.0d;

        char c = 'c';
        String S = "s";
        S += "tring";
        StringBuilder sb = new StringBuilder();
        sb.append("stringBuilder");

//        if()
//        {
//
//        }else{
//
//        }
//        for ()

//        while ()

        Type t = Type.A;
        switch(t){
            case A: break;
            case B: break;
        }
        Object o1 = new Object();
        Object o2 = new Object();
        boolean czek = o1.equals(o2);
        System.out.println(czek);

        @FunctionalInterface
        interface Action{
            double sun(double a, double b);
        }
        Function<Integer, Integer> fun = (a) -> 2*2;
        int wynik = fun.apply(1);
        System.out.println(wynik);
        Action fun2 = (A,B) -> A*B;
        double wynik2 = fun2.sun(5,5);
        System.out.println(wynik2);

        class UserEntity{
            Long id;
            String name;
        }

    }
    public enum Type{
        A(1, "A"),
        B(2, "B"),
        C(3, "C");
        private int id;
        private String name;

        Type(int id, String name)
        {
            this.id = id;
            this.name = name;
        }
        public int getId()
        {
            return id;
        }

        public String getName(){
            return name;
        }

        public static Type byName(String name)
        {
//            for(Type el : values()){
//                if(el.getName().equals(name))
//                    return el;
//            }
            switch(name){
                case "A":
                    return A;
                case "B":
                    return B;
                case "C":
                    return C;
            }

            return A;
        }
    }
}
