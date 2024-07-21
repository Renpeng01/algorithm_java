package org.example.sort;

public class InsertSort extends Example {
    public static void sort(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if (less(a[j], a[j-1])){
                    exch(a,j, j-1);
                }
            }
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
