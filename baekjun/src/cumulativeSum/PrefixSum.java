package cumulativeSum;

import java.io.*;
import java.util.StringTokenizer;

public class PrefixSum {

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.valueOf(st.nextToken());
        int m = Integer.valueOf(st.nextToken());
        arr = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = arr[i - 1] + Integer.valueOf(st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.valueOf(st.nextToken());
            int b = Integer.valueOf(st.nextToken());

            System.out.println(arr[b] - arr[a - 1]);
        }

    }
}
