package org.example.chapter2.sort;

public class Insertion {
    public class Selection {
        public static void sort(Comparable[] a){

            for (int i = 1; i < a.length; i++) {
                for (int j = i; j > 0; j--) {
                    if (less(a[j], a[j-1])) {
                        exch(a, j, j-1);
                    }
                }
            }
        }

        private static boolean less(Comparable v, Comparable w){
            return v.compareTo(w) < 0;
        }

        private static void exch(Comparable[] a, int i, int j){
            Comparable t = a[i];
            a[i] = a[j];
            a[j] = t;
        }

        private static void show(Comparable[] a){
            for(int i = 0; i < a.length; i++){
                System.out.print(a[i] + " ");
            }
            System.out.println();
        }

        public static boolean isSorted(Comparable[] a){
            for(int i = 1; i < a.length - 1; i++){
                if(less(a[i], a[i-1])){
                    return false;
                }
            }
            return true;
        }
        public static void main(String[] args) {

        }

    }

}
