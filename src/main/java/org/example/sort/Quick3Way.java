package org.example.sort;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Quick3Way {
    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
       if (hi <= lo){
           return;
       }

       int lt = lo;
       int i = lo+1;
       int gt = hi;

       while (i <= gt) {
           Comparable v = a[lt];
           int cmp = a[i].compareTo(v);
           if (cmp < 0){
               exch(a, lt++, i++);
           }else if (cmp > 0){
               exch(a, i, gt--);
           }else {
               i++;
           }
       }
       sort(a, lo, lt - 1);
       sort(a,gt+1, hi);
    }



    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        String[] a = StdIn.readAllStrings();
        String[] a = {"R","A","T","E","L","E","P","U","I","M","Q","C","X","O","S"};
        sort(a);
        assert isSorted(a);
        show(a);
    }
}