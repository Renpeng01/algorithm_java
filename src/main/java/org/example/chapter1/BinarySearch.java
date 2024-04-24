package org.example.chapter1;

public class BinarySearch {
    public static int rank(int key ,int[] a){
        int lo = 0;
        int hi = a.length - 1;

        while(lo < hi){
            int mid = lo + (hi - lo) / 2;
            if (key == a[mid]){
                return mid;
            }
            if (key < a[mid]){
                hi = mid - 1;
            }else{
                lo = mid + 1;
            }
        }
        return -1;
    }
}
