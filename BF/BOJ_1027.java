import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1027 { // 고층 건물
    static int N;
    static int[] building;
    static int[] visible;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.valueOf(br.readLine());
        building = new int[N];
        visible = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            building[i] = Integer.valueOf(st.nextToken());
        }
        count();

        Arrays.sort(visible);
        System.out.println(visible[visible.length - 1]);
    }
    static void count() {
        for (int i = 0; i < N - 1; i++) {
            visible[i]++; // 바로 옆 건물은 보임
            visible[i + 1]++; // 그 옆 건물에서도 현재 건물이 보임
            double slope = building[i + 1] - building[i];
            for (int j = i + 2; j < N; j++) {
                double nextSlope = (double) (building[j] - building[i]) / (j - i);
                if (nextSlope <= slope) {
                    continue;
                }
                slope = nextSlope;
                visible[i]++;
                visible[j]++;
            }
        }
    }
}
