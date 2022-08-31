import java.util.Arrays;

class Solution {
    public int solution(int n) {

        // ~n 까지의 소수 기록을 위한 배열 생성
        boolean[] primeCheck = new boolean[n + 1];

        // true는 소수, false는 소수가 아님을 의미
        Arrays.fill(primeCheck, true);

        primeCheck[0] = false;
        primeCheck[1] = false;

        int cnt = 0;
        for (int i = 2; i < primeCheck.length; i++) {
            if (primeCheck[i]) {
                cnt++;
                // 소수의 배수는 소수가 아님을 표시
                for (int j = i; j < primeCheck.length; j += i) {
                    primeCheck[j] = false;
                }
            }
        }

        return cnt;
    }
}