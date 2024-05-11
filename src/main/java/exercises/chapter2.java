package exercises;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;
import org.example.sort.Merge;

public class chapter2 {

    // 2.2.14
    public static Queue<Comparable> merge(Queue<Comparable> a, Queue<Comparable> b) {
        Queue<Comparable> mergedQueue = new Queue<>();

        while (!a.isEmpty() && !b.isEmpty()) {
            if (a.peek().compareTo(b.peek()) <= 0) {
                mergedQueue.enqueue(a.dequeue());
            } else {
                mergedQueue.enqueue(b.dequeue());
            }
        }

        while (!a.isEmpty()) {
            mergedQueue.enqueue(a.dequeue());
        }
        while (!b.isEmpty()) {
            mergedQueue.enqueue(b.dequeue());
        }
        return mergedQueue;
    }

    // 2.2.15
    public static Queue<Queue<Comparable>> sort(Comparable[] arr) {
        Queue<Queue<Comparable>> queue = new Queue<>();

        for (Comparable val : arr) {
            Queue<Comparable> tempQueue = new Queue<>();
            tempQueue.enqueue(val);
            queue.enqueue(tempQueue);
        }

        while (queue.size() > 1) {
            Queue<Comparable> q1 = new Queue<>();
            Queue<Comparable> q2 = new Queue<>();

            Queue<Comparable> mergedQueue = merge(q1, q2);
            queue.enqueue(mergedQueue);
        }
        return queue;
    }

    // 2.2.16
    private static void naturalMergesort(Comparable[] array) {
        if (array == null || array.length == 1) {
            return;
        }
        Comparable[] aux = new Comparable[array.length];

        int low = 0;
        int middle;
        int high;

        while (true) {
            middle = findSortedSubArray(array, low);
            if (middle == array.length - 1) {
                if (low == 0) // Array is sorted
                    break;
                else {
                    low = 0;
                    continue;
                }
            }
            high = findSortedSubArray(array, middle + 1);
            merge(array, aux, low, middle, high);
            low = (high == array.length - 1) ? 0 : high + 1;
        }
    }

    private static int findSortedSubArray(Comparable[] array, int start) {
        for (int i = start + 1; i < array.length; i++) {
            if (array[i].compareTo(array[i - 1]) < 0) {
                return i - 1;
            }
        }
        return array.length - 1;
    }


    public static void merge(Comparable[] array, Comparable[] aux, int low, int middle, int high) {
        for (int i = low; i <= high; i++) {
            aux[i] = array[i];
        }

        int leftIndex = low;
        int rightIndex = middle + 1;
        int arrayIndex = low;

        while (leftIndex <= middle && rightIndex <= high) {
            if (aux[leftIndex].compareTo(aux[rightIndex]) <= 0) {
                array[arrayIndex] = aux[leftIndex];
                leftIndex++;
            } else {
                array[arrayIndex] = aux[rightIndex];
                rightIndex++;
            }

            arrayIndex++;
        }

        while (leftIndex <= middle) {
            array[arrayIndex] = aux[leftIndex];
            leftIndex++;
            arrayIndex++;
        }
    }

    // 2.2.21
    public static Comparable triplicate(Comparable[] a, Comparable[] b, Comparable[] c) {
        Merge.sort(a);
        Merge.sort(b);
        Merge.sort(c);

        show(a);
        show(b);
        show(c);

        int ia = 0, ib = 0, ic = 0;
        while (ia < a.length && ib < b.length && ic < c.length) {
            if (a[ia].compareTo(b[ib]) > 0) {
                ib++;
            } else if (a[ia].compareTo(b[ib]) < 0) {
                ia++;
            } else {
                if (a[ia].compareTo(c[ic]) > 0) {
                    ic++;
                } else if (a[ia].compareTo(c[ic]) < 0) {
                    ia++;
                    ib++;
                }else{
                    return a[ia];
                }
            }
        }
        return null;
    }

    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }

    public static void main(String[] args) {
        String[] s1 = {"a","b","c"};
        String[] s2 = {"f","a","d"};
        String[] s3 = {"l","z","a"};

        Comparable res = triplicate(s1,s2,s3);
//        StdOut.println(res);

        StdOut.print(res);

    }
}
