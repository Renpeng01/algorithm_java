package org.example.sort;

import edu.princeton.cs.algs4.StdRandom;

public class QuickSort extends Example {
    public static void sort(Comparable[] a) {
        // 保持随机性，也可以在partition中随机找一个元素作为需要指定的元素
        StdRandom.shuffle(a);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }

        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);

    }

    // 切分过程中总能排定一个元素
    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        Comparable v = a[lo];
        while (true) {
            while (less(a[++i], v)) {
                if (i == hi) {
                    break;
                }
            }
            while (less(v, a[--j])) {
                if (j == lo) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }
}

// 快速排序是一种分治的排序算法。它将一个数组分成两个子数组，将两部分独立地排序。
// 快速排序和归并排序是互补的；归并排序将数组分成2个子数组分别排序，并将有序的子数组归并以将整个数组排序
// 而快速排序将数组排序的方式则是当两个数组都有序时，整个数组也就自然有序了
