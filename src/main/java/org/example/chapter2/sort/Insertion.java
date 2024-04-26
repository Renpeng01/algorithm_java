package org.example.chapter2.sort;

// 最坏的情况下需要 N²/2 次比较 和 N²/2 次交换
// 最好的情况下需要 N-1 次比较和0次交换
// 插入排序对于实际应用中的非随机数组有效
public class Insertion {
    public static void sort(Comparable[] a){
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if (less(a[j], a[j-1])) {
                    exch(a, j, j-1);
                }else{
                    break;
                }
            }
        }
    }
    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j){
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void show(Comparable[] a){
        for(int i = 0; i < a.length; i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static boolean isSorted(Comparable[] a){
        for(int i = 1; i < a.length - 1; i++){
            if(less(a[i], a[i-1])){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {

    }

}
