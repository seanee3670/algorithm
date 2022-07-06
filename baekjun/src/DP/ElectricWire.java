package DP;

import java.util.HashMap;
import java.io.*;
import java.util.StringTokenizer;

public class ElectricWire {

    static HashMap<Integer, Integer> map = new HashMap<>();
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int key = Integer.valueOf(st.nextToken());
            int val = Integer.valueOf(st.nextToken());

            map.put(key, val);
        }

        /*
        rule 1: wires should not cross.
            cross means :
            1) N > i && [N] < [i]
            2) N < i && [N] > [i]


        // rule 2: find a minimum number of wires to be removed.
            how to implement change in counts before and after removal?
            1) add dp[N] to count number of intersection?
            2)

        // things to consider
        1) when N == 1


         */
    }
}
