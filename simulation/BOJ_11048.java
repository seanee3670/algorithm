import java.io.*;
import java.util.*;

public class BOJ_11048 { // 이동하기
    static int row;
    static int col;
    static int[][] arr;
    static int[][] dp;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        row = Integer.valueOf(st.nextToken());
        col = Integer.valueOf(st.nextToken());

        arr = new int[row + 1][col + 1];

        for (int i = 1; i <= row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= col; j++) {
                arr[i][j] = Integer.valueOf(st.nextToken());
            }
        }

        dp = new int[row + 1][col + 1];

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                dp[i][j] = Math.max(arr[i][j] + dp[i - 1][j], arr[i][j] + dp[i][j - 1]);
            }
        }

        System.out.println(dp[row][col]);

    }


    static void printBoard() {
        for (int[] ar : arr) {
            for (var e : ar) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }
}
