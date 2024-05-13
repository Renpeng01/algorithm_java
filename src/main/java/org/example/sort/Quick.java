package org.example.sort;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Quick {
    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    // 哨兵模式的快排
    public static void sort2(Comparable[] a) {
        StdRandom.shuffle(a);

        int maxIndex = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i].compareTo(a[maxIndex]) > 0) {
                maxIndex = i;
            }
        }
        exch(a, maxIndex, a.length - 1);
        sort(a, 0, a.length - 1);
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        Comparable v = a[lo];
        while (true) {
            while (less(a[++i], v)) if (i == hi) break; // 如果 a[lo] 是整个集合的最大值，则会走这个逻辑
            while (less(v, a[--j])) if (j == lo) break; // 如果 a[lo] 是整个集合的最小值，则会走这个逻辑
            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    private static int partition2(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        Comparable v = a[lo];
        while (true) {
            while (less(a[++i], v)) {
            }
            while (less(v, a[--j])) {
            }
            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
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
        String[] a = {"R", "A", "T", "E", "L", "E", "P", "U", "I", "M", "Q", "C", "X", "O", "S"};
        sort(a);
        assert isSorted(a);
        show(a);
    }
}

// 优化
// 1. 对于一个小数组，快速排序比插入排序慢
// 2. 因为递归，快速排序sort方法在小数组中也会调用自己
// 因此，在排序小数组时应切换到插入排序  小数组的个数范围在5~15之间

// 优化
// 三取样切分
