package org.example.search;

public class BinarySearch {
    public static int rank(int key, int[] arr) {
        int lo = 0;
        int hi = arr.length-1;
        int mid = lo + (hi - lo) /2;
        while (hi >= lo){
            if (arr[mid] == key){
                return mid;
            }

            if (arr[mid] > key){
                hi = mid-1;
            }else{
                lo = mid+1;
            }
            mid = lo + (hi - lo) /2;
        }
        return -1;
    }

    public static void main(String[] args){
        int[] arr = {0,1,2,3,4,5};
        int indexExist = rank(5,arr);
        System.out.printf("exist index: %d\n",indexExist);


        int indexInexist = rank(6,arr);
        System.out.printf("inexist index: %d",indexInexist);
    }
}
