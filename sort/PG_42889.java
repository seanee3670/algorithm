import java.util.*;

public class PG_42889 { // 실패율
    public List<Integer> solution(int N, int[] stages) {
        int[] failCnts = new int[N + 2];
        int[] totalCnts = new int[N + 1];

        for (int stage : stages) {
            failCnts[stage]++;
        }

        totalCnts[N] = failCnts[N] + failCnts[N - 1];
        for (int i = N - 1; i >= 1; i--) {
            totalCnts[i] = failCnts[i] + totalCnts[i + 1];
        }

        Map<Integer, Double> ratesByStage = new HashMap<>();
        for (int i = 1; i < totalCnts.length; i++) {
            if (failCnts[i] == 0 || totalCnts[i] == 0) {
                ratesByStage.put(i, 0.0);
            } else {
                ratesByStage.put(i, (double) failCnts[i] / totalCnts[i]);
            }
        }
        List<Integer> list = new ArrayList<>(ratesByStage.keySet());
        Collections.sort(list, (o1, o2) -> Double.compare(ratesByStage.get(o2), ratesByStage.get(o1)));

        return list;
    }
}