package org.example.sort;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class SortCompare {
    public static double time(String alg, Comparable[] a) {
        Stopwatch timer = new Stopwatch();
        if (alg.equals("Insertion")) {
            Insertion.sort(a);

        }else if (alg.equals("Selection")) {
            Selection.sort(a);

        }else if (alg.equals("Shell")) {
            Shell.sort(a);
        }
        if (alg.equals("Merge")) {
            Merge.sort(a);
        }
//        if (alg.equals("Quick")) {}
//        if (alg.equals("Heap")) {}
        return timer.elapsedTime();
    }

    public static double timeRandomInput(String alg, int N, int T) {
        double total = 0.0;
        Double[] a = new Double[N];
        for (int t = 0; t < T; t++) {
            for (int i = 0; i < N; i++) {
                a[i] = StdRandom.uniform();
            }
            total += time(alg, a);
        }
        return total;
    }

    public static void main(String[] args) {
//        String alg1 = args[0];
//        String alg2 = args[1];
//        int N = Integer.parseInt(args[2]);
//        int T = Integer.parseInt(args[3]);
//        double t1 = timeRandomInput(alg1, N, T);
//        double t2 = timeRandomInput(alg2, N, T);

        String alg1 = "Insertion";
        String alg2 = "Selection";
        String alg3 = "Shell";
        String alg4 = "Merge";
        int N = 10000;
        int T = 100;
        double t1 = timeRandomInput(alg1, N, T);
        double t2 = timeRandomInput(alg2, N, T);
        double t3 = timeRandomInput(alg3, N, T);
        double t4 = timeRandomInput(alg4, N, T);


        StdOut.printf("%s: %.5f \n", alg1,t1);
        StdOut.printf("%s: %.5f \n",  alg2,t2);
        StdOut.printf("%s: %.5f \n", alg3,t3);
        StdOut.printf("%s: %.5f \n", alg4,t4);


//        StdOut.printf("For %d random Doubles\n %s is", N, alg1);
//        StdOut.printf(" %.1f times faster than %s \n",t2/t1,alg2);
    }
}
