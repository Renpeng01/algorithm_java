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


// ********************************]
// 时间复杂度 O(n²)
// 空间复杂度 O(1)

// 对于长度为N的数组，选择排序需要大约N²/2 次比较和N次交换
// 运行时间和输入无关（为了找出最小的元素而扫描一遍数组并不能为下一遍扫描提供信息），和输入规模有关
// 一个已经有序的数组或主键全部相等的数组和一个元素随机排列的数组所用额排序时间一样
// 数据移动是最少的，每次交换都会改变2个数组元素的值