package Dodatkowe2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args)
    {
        // tablica z duplikatami
        System.out.println("Lista z duplikatami");
        String[] lista = new String[]{"a","a","a","b","c","d","e","f","g","h","i","j","k","k","k","k","l","m","n","o","p","r","s","t","u","w","x","y","z","z"};
        Iterator<String> iterator = Arrays.stream(lista).iterator();
        while(iterator.hasNext())
        {
            String linia = iterator.next();
            if(!iterator.hasNext())
            {
                System.out.println(linia);
                break;
            }
            System.out.print(linia+" ");
        }

        System.out.println("Lista bez duplikatów");
        HashSet hash = new HashSet(List.of(lista));
        iterator = hash.iterator();
        while(iterator.hasNext())
        {
            String linia = iterator.next();
            if(!iterator.hasNext())
            {
                System.out.println(linia);
                break;
            }
            System.out.print(linia+" ");
        }

    }
}
