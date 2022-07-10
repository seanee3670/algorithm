package DP;

import java.io.*;

public class CountingFibonacci {

    static int[] fib;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());
        fib = new int[N + 1];
        fib[4] = 3;
        fib[5] = 5;

        System.out.println(countFib(N) + " " + (N - 2));

    }

    static int countFib(int N) {

        for (int i = 6; i < N + 1; i++) {
            fib[i] += fib[i - 1] + fib[i - 2];
        }

        return fib[N];
    }
}
