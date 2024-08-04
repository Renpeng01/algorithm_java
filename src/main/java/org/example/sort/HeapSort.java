package org.example.sort;

public class HeapSort extends Example {

    public static void sort(Comparable[] a) {
        int N = a.length-1;

        // 构造堆
        for (int k = N / 2; k >= 1; k--) {
            sink(a, k, N);
        }

        // 按顺序取出
        while (N > 1) {
            exch(a, 1, N--);
            sink(a, 1, N);
        }
    }

    private static void sink(Comparable[] a, int k, int N) {
        while (2 * k <= N) {
            int j = k * 2;
            if (j < N && less(a[j], a[j + 1])) {
                j++;
            }
            if (!less(a[k], a[j])) {
                break;
            }
            exch(a, k, j);
            k = j;
        }
    }

    public static void main(String[] args) {
        Integer[] a = {0, 1, 2, 9, 7, 2, 5, 7};
        show(a);
        sort(a);
        show(a);
    }
}
