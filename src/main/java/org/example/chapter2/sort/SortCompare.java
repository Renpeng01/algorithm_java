package org.example.chapter2.sort;

public class SortCompare {

    public static double time(String alg, Double[] a) {

    }

    public static double timeRandomInput(String alg, int N, int T) {
        double total = 0;
        Double[] a = new Double[N];
        for (int t = 0; t < T; t++) {
            for (int i = 0; i < N; i++) {
                a[i] = Math.random();
            }
            total += time(alg,a);
        }
        return total;
    }

    public static void main(String[] args) {

    }
}
