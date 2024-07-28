package org.example.sort;

public class InsertSort extends Example {
    public static void sort(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if (less(a[j], a[j-1])){
                    exch(a,j, j-1);
                }
            }
            show(a);
        }
    }

    public static void main(String[] args) {
        String[] a = {"E", "A", "S", "Y", "Q", "U", "E", "S", "T", "I", "O", "N"};
        sort(a);

        assert isSorted(a);
    }
}

// 和选择排序一样，当前索引左边的所有元素都是有序的，但不是最终的位置
// 所需的时间取决于输入中元素的初始顺序

// 对于随机排列的长度为N且主键不重复的数组，平均情况下插入排序需要N²/4 次比较 和 N²/4 次交换
// 最坏情况下需要N²/2 次比较 和 N²/2 次交换
// 最好情况下需要N-1次比较和0次交换

// 插入排序需要的交换操作和数组中倒置的数据相同，需要的比较次数大于等于倒置的数量，小于等于倒置的数量加上数组
// 的大小再减1