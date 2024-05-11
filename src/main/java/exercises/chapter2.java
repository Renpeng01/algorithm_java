package exercises;

import edu.princeton.cs.algs4.Queue;
import jdk.jfr.Frequency;

import java.util.Comparator;
import java.util.concurrent.ConcurrentMap;

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

        for(Comparable val : arr){
            Queue<Comparable> tempQueue = new Queue<>();
            tempQueue.enqueue(val);
            queue.enqueue(tempQueue);
        }

        while (queue.size() > 1){
            Queue<Comparable> q1 = new Queue<>();
            Queue<Comparable> q2 = new Queue<>();

            Queue<Comparable> mergedQueue = merge(q1, q2);
            queue.enqueue(mergedQueue);
        }
        return queue;
    }


}
