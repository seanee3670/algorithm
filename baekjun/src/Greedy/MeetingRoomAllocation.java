package Greedy;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class MeetingRoomAllocation {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        /*
            meetingTimeTable[][0] 은 시작 시점
            meetingTimeTable[][1] 은 종료 시점
         */

        int[][] meetingTimeTable = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            meetingTimeTable[i][0] = Integer.valueOf(st.nextToken());
            meetingTimeTable[i][1] = Integer.valueOf(st.nextToken());
        }

        Arrays.sort(meetingTimeTable, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // 종료시간이 같은 경우 시작시간이 빠른 순으로 정렬
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }

                return o1[1] - o2[1];
            }
        });

        int count = 0;
        int prevEndTime = 0;

        for (int i = 0; i < N; i++) {
            // 직전 종료시간이 다음 회의 시작 시간보다 작거나 같다면 갱신
            if (prevEndTime <= meetingTimeTable[i][0]) {
                prevEndTime = meetingTimeTable[i][1];
                count++;
            }
        }

        System.out.println(count);

    }

}
