import java.util.*;
import java.io.*;

public class HSAT_1256 { // [HSAT 5회 정기 코딩 인증평가 기출] 업무 처리
    static int H;
    static int K;
    static int R;
    static Worker[] tree;
    static int answer;

    static class Worker {
        int depth;
        Queue<Integer> leftJobs;
        Queue<Integer> rightJobs;
        Queue<Integer> currentJobs;

        public Worker(int depth) {
            this.depth = depth;
            initJobs();
        }

        public void initJobs() {
            if (depth == H) {
                currentJobs = new LinkedList<>();
            } else {
                leftJobs = new LinkedList<>();
                rightJobs = new LinkedList<>();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.valueOf(st.nextToken()); // 높이
        K = Integer.valueOf(st.nextToken()); // 업무 갯수
        R = Integer.valueOf(st.nextToken()); // 날짜

        final int idxOfFirstJunior = (int) Math.pow(2, H);
        tree = new Worker[idxOfFirstJunior * 2];
        initTree(1, 0);

        for (int i = idxOfFirstJunior; i < idxOfFirstJunior * 2; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < K; j++) {
                tree[i].currentJobs.offer(Integer.valueOf(st.nextToken()));
            }
        }

        answer = 0;
        for (int date = 1; date <= R; date++) {
            work(1, date, 0);
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }

    static void work(int idx, int r, int depth) {
        if (depth > H) return;

        Worker worker = tree[idx];
        if (depth == H && !worker.currentJobs.isEmpty()) {
            int job = worker.currentJobs.poll();
            if (idx % 2 == 0) tree[idx / 2].leftJobs.offer(job);
            else tree[idx / 2].rightJobs.offer(job);
        } else if (depth < H && r % 2 == 0 && !worker.rightJobs.isEmpty()) {
            int job = worker.rightJobs.poll();
            if (idx == 1) answer += job;
            else {
                if (idx % 2 == 0) tree[idx / 2].leftJobs.offer(job);
                else tree[idx / 2].rightJobs.offer(job);
            }
        } else if (depth < H && r % 2 == 1 && !worker.leftJobs.isEmpty()) {
            int job = worker.leftJobs.poll();
            if (idx == 1) answer += job;
            else {
                if (idx % 2 == 0) tree[idx / 2].leftJobs.offer(job);
                else tree[idx / 2].rightJobs.offer(job);
            }
        }

        work(idx * 2, r, depth + 1);
        work(idx * 2 + 1, r, depth + 1);
    }


    static void initTree(int idx, int depth) {
        if (depth > H) {
            return;
        }
        Worker newWorker = new Worker(depth);
        tree[idx] = newWorker;

        initTree(idx * 2, depth + 1);
        initTree(idx * 2 + 1, depth + 1);
    }

}
