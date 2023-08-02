import java.util.Arrays;

public class PG_77484 { // 로또의 최고 순위와 최저 순위
    public int[] solution(int[] lottos, int[] win_nums) {
        Arrays.sort(lottos);
        Arrays.sort(win_nums);

        int numZeros = 0;
        int numSame = 0;
        int idx = 0;
        for (int lotto : lottos) {
            if (lotto == 0) {
                numZeros++;
                idx++;
            } else {
                break;
            }
        }

        int idx2 = 0;
        while(idx < lottos.length && idx2 < win_nums.length) {
            if (lottos[idx] == win_nums[idx2]) {
                numSame++;
                idx++;
                idx2++;
            } else if (lottos[idx] < win_nums[idx2]) {
                idx++;
            } else {
                idx2++;
            }
        }
        int maxWin = 7 - (numZeros + numSame);
        int minWin = 7 - (numSame);

        if (maxWin > 6) {
            maxWin = 6;
        }
        if (minWin > 6) {
            minWin = 6;
        }

        return new int[] { maxWin, minWin };
    }
}
