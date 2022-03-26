package Dodatkowe1_2;

import java.util.*;

public class Main {

    public static void main(String[] args)
    {
        // arraylist petla
        System.out.println("LinkedList w pętli");
        String[] lista = new String[]{"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","r","s","t","u","w","x","y","z"};
        List<String> list = new LinkedList<String>(List.of(lista));
        for(int i = list.size()-1;i>=0;i--)
        {
            if(i % 2 == 0)
                list.remove(i);
        }
        for(int i = 0;i<list.size();i++)
        {
            if(i == list.size()-1) {
                System.out.println(list.get(i));
                break;
            }
            System.out.print(list.get(i) + ", ");
        }

        // arraylist z iteratorem
        System.out.println("LinkedList z iteratorem");
        List<String> list2 = new LinkedList<String>(List.of(lista));
        boolean switchBool = true;
        Iterator<String> iterator = list2.iterator();
        while(iterator.hasNext())
        {
            String line = iterator.next();
            if(switchBool) {
                iterator.remove();
                switchBool = false;
            }
            else {
                switchBool = true;

                if(!iterator.hasNext())
                {
                    System.out.println(line);
                    break;
                }
                System.out.print(line+ ", ");

            }
        }
    }
}
