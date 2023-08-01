import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9252 { // LCS 2
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr1 = br.readLine().toCharArray();
        char[] arr2 = br.readLine().toCharArray();
        int[][] dp = new int[arr1.length][arr2.length];

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i] == arr2[j]) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }

        int x = arr2.length;
        int y = arr1.length;
        StringBuilder sb = new StringBuilder();

        while (x != 0 && y != 0) {
//            if (arr)
        }
    }
}
