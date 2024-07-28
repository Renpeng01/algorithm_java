package org.example.sort;

public class Merger extends Example {

    private static Comparable[] aux;

    // 自底向上
    public static void sort1(Comparable[] a){
        aux = new Comparable[a.length];
        for(int sz = 1; sz < a.length; sz = sz + sz){
            for(int lo = 0; lo <a.length-sz; lo += sz){
                merge(a,lo,lo+sz-1, Math.min(lo + sz + sz-1,a.length-1));
            }
        }
    }

    // 自顶向下
    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sort(a,0,a.length-1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);


        // 如果a[mid] 小于等于 a[mid+1] 则2个、部分已经是有序的，不需要merger了
        if (less(a[mid+1],a[mid])){
            merge(a, lo, mid, hi);
        }
    }

    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;

        for (int k = 0; k < a.length; k++) {
            aux[k] = a[i];
        }

        for (int k = lo; k < hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = a[i++];
            } else if (less(aux[j], aux[i])) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }
    }
}
// 对于长度为N的任意数组，自动乡下的归并排序需要 NlgN/2~ NlogN次比较
// 证明：

// 对于长度为N的任意数组，自顶向下的归并排序最多需要访问数组 6NlogN次
// 证明：


// 对于小规模子数组，使用插入排序
// 效率：插入排序在数据基本有序时效率高，选择排序无论数据如何分布，效率都较低。
// 稳定性：插入排序是稳定的，选择排序是不稳定的。
// 元素移动：插入排序可能需要更多的元素移动，但选择排序每次只进行一次交换


