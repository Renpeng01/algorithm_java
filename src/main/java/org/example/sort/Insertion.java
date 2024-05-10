package org.example.sort;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;


// 所需的时间取决于输入中元素的初始顺序。对一个很大且其中的元素已经有序（或接近有序）的数组
// 将会比随机顺序的数组要快的多
public class Insertion {
    public static void sort(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            // 条件less(a[j], a[j - 1]) 的位置是关键
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
        }
    }


    // 插入排序的哨兵，在插入排序的中线找出最小的元素并将其置于数组最左边，这样就能去掉内循环中的 j > 0 的操作
    public static void sort2(Comparable[] a) {
        int minIndex = 0;
        for (int i = 1; i < a.length; i++) {
            if (less(a[i],a[minIndex])){
                minIndex = i;
            }
        }
        exch(a,minIndex,0);


        for (int i = 1; i < a.length; i++) {
            // 条件less(a[j], a[j - 1]) 的位置是关键

            int j = i;
            while (less(a[j], a[j - 1])){
                exch(a, j, j - 1);
                j--;
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
        assert isSorted(a);
        show(a);
    }
}

// 所需的时间取决于输入元素的初始顺序
// 适合部分有序和小规模数组
