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

    private static void sort3Way(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }

        int lt = lo;
        int i = lo + 1;
        int gt = hi;
        Comparable v = a[lo];

        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            if (cmp < 0) {
                exch(a, i++, lt++);
            } else if (cmp > 0) {
                exch(a, i++, gt--);
            } else {
                i++;
            }
        }
        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);

    }
}

// 快速排序是一种分治的排序算法。它将一个数组分成两个子数组，将两部分独立地排序。
// 快速排序和归并排序是互补的；归并排序将数组分成2个子数组分别排序，并将有序的子数组归并以将整个数组排序
// 而快速排序将数组排序的方式则是当两个数组都有序时，整个数组也就自然有序了

// 性能问题 左侧扫描最好是在遇到大于等于切分元素值的元素停下，右侧扫描则是遇到小于等于切分元素值的元素时停下。
// 尽管这样可能会不必要地将一些等值的元素交换，但在某些典型应用中，能够避免算法的运行时间变为平方级别（例题 2.3.11）

// 优化
// 1. 对于小数组，快速排序比插入排序慢
// 2. 三取样切分  使用子数组的一小部分元素的中位数来切分数组。这样做得到的切分更好，但代价是需要计算中位数 （2.3.18, 2.3.19）
// 3. 熵最优排序 实际应用中经常会出现大量重复元素。 （荷兰旗问题）