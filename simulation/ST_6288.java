import java.io.*;
import java.util.*;

public class ST_6288 { // 금고털이

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int W = Integer.valueOf(st.nextToken());
        int N = Integer.valueOf(st.nextToken());

        int[][] jewels = new int[N][2];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            jewels[i][0] = Integer.valueOf(st.nextToken());
            jewels[i][1] = Integer.valueOf(st.nextToken());
        }

        // sort desc by 2nd element
        Arrays.sort(jewels, (a,b) -> {
            if (a[1] != b[1]) return b[1] - a[1];
            if (a[0] != b[0]) return b[0] - a[0];
            return 0;
        });

        int price = 0;
        for (int[] jewel : jewels) {
            if (jewel[0] <= W) {
                W -= jewel[0];
                price += (jewel[0] * jewel[1]);
            } else {
                price += (W * jewel[1]);
                W = 0;
                break;
            }
        }

        System.out.println(price);


    }
}

