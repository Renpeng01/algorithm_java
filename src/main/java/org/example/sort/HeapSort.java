package org.example.sort;

public class HeapSort extends Example {

    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = N / 2; i >= 1; i--) {
            sink(a, i, N);
        }
        while (N > 1) {
            exch(a, 1, N--);
            sink(a, 1, N);
        }
    }

    private static void sink(Comparable[] a, int k, int N) {
        while (2 * k <= N) {
            int j = k * 2;
            if (j < N && less(j, j + 1)) {
                j++;
            }
            if (!less(k, j)) {
                break;
            }
            exch(a, k, j);
            k = j;
        }
    }

    public static void main(String[] args) {
        Integer[] a = {1, 2, 9, 7, 2, 5, 7};
        show(a);
        sort(a);
        show(a);
    }
}
