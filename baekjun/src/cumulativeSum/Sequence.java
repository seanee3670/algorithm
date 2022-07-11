package cumulativeSum;

import java.io.*;
import java.util.StringTokenizer;

public class Sequence {

    static int[] arr;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.valueOf(st.nextToken());
        int M = Integer.valueOf(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.valueOf(st.nextToken());
        }

        System.out.println(findMax(arr, M));

    }

    static int findMax(int[] arr, int M) {
        int max = Integer.MIN_VALUE;
        int temp;

        for (int i = 0; i < arr.length - M + 1; i++) {
            temp = 0;
            for (int j = 0; j < M; j++) {
                temp += arr[i + j];
            }
            max = Math.max(temp, max);
        }
        return max;
    }

}
