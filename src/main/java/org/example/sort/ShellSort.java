package org.example.sort;


// 基于插入排序的算法
// 对于大规模乱序数组插入排序很慢，因为他只会叫唤相邻的元素，因此元素只能一点一点地从数组的一端移动到另一端
// 希尔排序为了加快速度简单地改进了插入排序，交换不相邻的元素以对数组的局部进行排序，并最终插入排序将局部有序的数组排序

// 希尔排序的思想是使数组中任意间隔为h的元素都是有序的，这样的数组被称为h有序数组
// 在排序时，如果h很大，就能将元素移动到很远的地方，为实现更小的h有序创造方便

public class ShellSort extends Example {

    public static void sort(Comparable[] a) {
        int h = 1;
        int N = a.length;
        while (h < N / 3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            for (int i = h; i < a.length; i += h) {
                for (int j = i; j > 0; j -= h) {
                    if (less(a[j], a[j - h])) {
                        exch(a, j, j - h);
                    }
                }
                show(a);
            }
            h = h / 3;
        }
    }

    public static void main(String[] args) {
        String[] a = {"E", "A", "S", "Y", "Q", "U", "E", "S", "T", "I", "O", "N"};
        sort(a);
        assert isSorted(a);
    }
}

// 希尔排序比插入排序和选择排序要快，并且数组越大，优势越大
