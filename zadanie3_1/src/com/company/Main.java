package com.company;

public class Main {

    public static void main(String[] args) {
        int[] array = { 4, 5, 7, 11, 12, 15, 15, 21, 40, 45 };

        System.out.println(searchIndex(array,12));
    }

    public static int searchIndex(int[] tablica, int value)
    {
        int index = 0;
        int limit = tablica.length - 1;
        while (index <= limit) {
            int point = (int) Math.ceil((index + limit) / 2.0);
            int entry = tablica[point];
            if (value > entry) {
                index = point + 1;
                continue;
            }
            if (value < entry) {
                limit = point - 1;
                continue;
            }
            return point; // value == entry
        }
        return -1;
    }

}

