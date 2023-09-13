import java.util.*;
import java.io.*;

public class CT_UnstableMovingWalk { //  불안한 무빙워크 G5
    static int len;
    static int limit;
    static int[] arr;
    static boolean[] isPerson;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        len = Integer.valueOf(st.nextToken());
        limit = Integer.valueOf(st.nextToken());

        System.out.println(len + " " + limit);
        arr = new int[len * 2];
        isPerson = new boolean[len * 2];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.valueOf(st.nextToken());
        }

        // for (int i : arr) {
        //     System.out.println(i);
        // }

        int answer = 0;
        int start = 0;
        int end = 0;

        while (true) {
            System.out.println("________");
            answer++;
            // 무빙워크가 한 칸 회전합니다.
            start = (start + (len * 2) - 1) % (len * 2); // 0 -> 5
            end = (start + len - 1) % (len * 2); // start 5 -> end 2(7)

            System.out.println(start + " " + end);

            getOff(end);

            // 먼저 탄 사람부터 1칸 전진
            for (int i = end; i != start; i = (i + (len * 2) - 1) %(len * 2)) { // 0 -> 5
                if (!isPerson[i]) {
                    continue;
                }
                int next = (i + 1) % (len * 2);
                // 앞 사람이 있거나 안정성 0 이면 이동 x
                if (isPerson[next] || arr[next] == 0) {
                    continue;
                }

                // 앞으로 이동
                isPerson[i] = false;
                isPerson[next] = true;
                arr[next]--;

            }
            getOff(end);

            // 1번 칸에 사람이 없고 안정성이 0이 아니라면 사람을 한 명 더 올립니다.
            if (!isPerson[start] && arr[start] > 0) {
                isPerson[start] = true;
                arr[start]--;
            }



            // 안정성 0인 칸이 0개 이상일때 while loop 종료
            int cnt = 0;
            for (int plate : arr) {
                if (plate <= 0) {
                    cnt++;
                }
            }

            System.out.println("cnt: " + cnt);

            if (cnt >= limit) {
                break; // while loop break;
            }
        } // end of while loop
        System.out.println(answer);


    }
    static void getOff(int end) {
        if (isPerson[end]) {
            isPerson[end] = false;
        }
    }

}
