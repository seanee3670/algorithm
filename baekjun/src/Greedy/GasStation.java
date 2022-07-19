package Greedy;

import java.io.*;
import java.util.StringTokenizer;

public class GasStation {

    static int N;
    static int[] distance;
    static int[] price;
    static int[] rank;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.valueOf(br.readLine()) - 1;
        distance = new int[N];
        price = new int[N];
        rank = new int[N];


        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            distance[i] = Integer.valueOf(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            price[i] = Integer.valueOf(st.nextToken());
        }

        // rank by lowest price
        rankByLowestPrice();

        int totalCost = calculateOptimizedCost(0);

        // 다음 도시에서 사는것이 이득인 경우, 최소한 기름만 산다
        if (totalCost == 0) {
            totalCost = price[0] * distance[0];
        }

        // 두번째 도시부터는 패스 가능
        for (int i = 1; i < N; i++) {
            totalCost += calculateOptimizedCost(i);
        }

        System.out.println(totalCost);

        //

        /*
        rule 1: 첫번째 도시에선 무조건 기름을 채워야 한다. (두번째 도시부턴 패스 가능)
        rule 2: 각 도시의 가격과 거리 계산

         */

        /*
        plan 1: 2 ~ N 까지의 도시 기름값을 비교해서 우선순위를 맨들어보자(공동 순위 가능)...
            -> 우선순위 순서면 나머지 거리만큼 기름을, 그렇지 않으면..
            -> 다음 도시 기름 가격과 비교해서 비싸면 필요경비만큼, 그렇지 않으면..
            -> 높은 우선 순위가 나올때까지 계속 비교
            ->

         */



    }

    static void rankByLowestPrice() {
        for (int i = 0; i < N; i++) {
            rank[i] = 1;
            for (int j = 0; j < N; j++) {
                if (price[i] > price[j]) {
                    rank[i]++;
                }
            }
        }
    }

    static int calculateOptimizedCost(int idx) {
        // 다음 우선순위까지의 비용(거리 * 리터당 가격)을 계산한다.
        int OptimizedCost = 0;
        // 우선순위 비교
        for (int i = idx + 1; rank[idx] < rank[i]; i++) {
            OptimizedCost += price[idx] * distance[i - 1];
        }
        return OptimizedCost;
    }
}
