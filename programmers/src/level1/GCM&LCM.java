class Solution {
    public int[] solution(int n, int m) {

        int[] answer = new int[2];

        int small = n < m ? n : m;
        int big =  m > n ? m : n;

        // 최대공약수
        for (int i = small; i > 0; i--) {
            if (big % i == 0) {
                answer[0] = i;
                break;
            }
        }

        // 최소공배수
        for (int i = big; i <= big * small; i += big) {
            if (i % n == 0) {
                answer[1] = i;
                break;
            }

        }

        return answer;
    }
}