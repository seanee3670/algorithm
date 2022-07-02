package DP;

import java.io.*;

public class MakeOneMyAttempt {
    static Integer[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());
        arr = new Integer[N + 1];
        arr[0] = 0;
        arr[1] = 0;

        System.out.println(getMinCal(N));
    }

    public static int getMinCal(int N) {
        if (N == 1) {
            return arr[N];
        }

        if (arr[N] == null) {
            if (N % 3 == 0) {
                arr[N] = getMinCal(N / 3) + 1;
            }

            if (N % 2 == 0) {
                arr[N] = getMinCal(N / 2) + 1;
            }

            // N - 1
            arr[N] = getMinCal(N - 1) + 1;
        }

        return arr[N];
    }
}
