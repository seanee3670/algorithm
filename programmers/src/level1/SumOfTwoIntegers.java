class Solution {
    public long solution(int a, int b) {
        if (a == b) {
            return a;
        }

        long big = a - b > 0 ? a : b;
        long sml = big == a ? b : a;

        long sum = 0;

        for (long i = sml; i <= big; i++) {
            sum += i;
        }

        return sum;

    }

}