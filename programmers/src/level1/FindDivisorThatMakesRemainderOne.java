import java.util.Arrays;

class Solution {
    public int solution(int n) {

        boolean[] prime = new boolean[n];

        Arrays.fill(prime, true);

        prime[0] = false;
        prime[1] = false;

        for (int i = 2; i < n; i++) {
            if (prime[i]) {
                for (int j = i; j < n; j += i) {
                    prime[j] = false;
                }
                if (n % i == 1) {
                    return i;
                }
            }
        }
        return 0;
    }
}