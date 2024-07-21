package org.example.sort;

import java.util.concurrent.ConcurrentMap;

public class SelectSort extends Example {
    public static void sort(Comparable[] a) {
        if (a == null || a.length == 0) {
            return;
        }
        for (int i = 0; i < a.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < a.length; j++) {
                if (less(a[j], a[minIndex])) {
                    minIndex = j;
                }
            }
            exch(a,minIndex,i);
        }
    }

    public static void main(String[] args) {
        Integer[] a = {1,3,6,4,9,1,2,4};
        show(a);
        sort(a);
        show(a);
        assert isSorted(a);
    }
}
