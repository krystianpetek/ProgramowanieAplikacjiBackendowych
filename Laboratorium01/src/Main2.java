//package com.company;
//
//public class Main2 {
//
//    public static void main(String[] args)
//    {
//        int[] array = {4,5,7,11,12,15,15,21,40,45};
//        int index = searchIndex(array, 11); // we want to find index for 11
//        System.out.println(index);
//    }
//
//
//        public static int split (int index,int limit){
//            if (index > limit) {
//                return -1;
//            }
//            if (index > limit) {
//                return -1;
//            }
//            int point = (int) Math.ceil((limit + index) / 2.0);
//            int entry = array[point];
//            if (value < entry) {
//                return split(index, point - 1);
//            }
//            if (value > entry) {
//                return split(point + 1, limit);
//            }
//            return point; // value == entry
//        }
//
//    public static int searchIndex(int[] array,int value) {
//        return split(0, array.length - 1);
//        }
//
//
//}