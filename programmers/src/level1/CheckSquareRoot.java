class Solution {
    public long solution(long n) {

        double sqrtN = Math.sqrt(n);

        if (sqrtN % 1 > 0) {
            return -1;
        }

        sqrtN++;

        return (long) (sqrtN * sqrtN);
    }
}