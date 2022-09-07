class Solution {
    public long solution(int a, int b) {
        return sumFromAToB(Math.min(a, b), Math.max.(a, b));
    }

    private long sumFromAToB(long a, long b) {
        return (b - a + 1) * (a + b) / 2;
    }
}