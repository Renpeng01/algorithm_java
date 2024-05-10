package org.example.sort;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.List;

public class Shell {
    public static void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        while (h < N / 3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
                }
                show(a);
            }
            h = h / 3;
        }

    }

    public static void sort2(Comparable[] a) {
        int N = a.length;
        int h = 1;

        ArrayList<Integer> hs = new ArrayList<>();
        hs.add(h);
        while (h < N / 3) {
            h = 3 * h + 1;
            hs.add(h);
        }

        for(int m = hs.size()-1; m >= 0; m--) {
            h = hs.get(m);
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
                }
                show(a);
            }
        }
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
        String[] a = {"E","A","S","Y","S","H","E","L","L","Q","U","E","S","T","I","O","N"};
        sort2(a);
//        assert isSorted(a);
//        show(a);
    }
}


// 基于插入排序的的快速的排序算法

// 使数组中任意间隔h的元素都是有序的，这样的数组被称为h有序数组。在进行排序时，如果h很大，就能将元素移动到很远的地方，为实现更小的h有序创造方便。用这种方式，对任意以1结尾的h序列，都能够将数组排序