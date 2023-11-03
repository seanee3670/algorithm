import java.io.*;
import java.util.*;

public class ST_6291 { // 강의실 배정 (LV3 : 17min)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());
        int[][] lectures = new int[N][2];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            lectures[i][0] = Integer.valueOf(st.nextToken());
            lectures[i][1] = Integer.valueOf(st.nextToken());
        }

        // sort by ending time early, start time late
        Arrays.sort(lectures, (a, b) -> {
            if (a[1] != b[1]) return a[1] - b[1];
            else if (a[0] != b[0]) return b[0] - a[0];
            return 0;
        });

        int ans = 1;
        int end = lectures[0][1];
        for (int i = 1; i < lectures.length; i++) {
            if (lectures[i][0] >= end) { // new class starts after prev end
                ans++;
                end = lectures[i][1];
            }
        }
        System.out.println(ans);
    }

}
