class Solution {
    public int[] solution(int n, int m) {

        int[] answer = new int[2];

        int big = m;
        int small = n;

        if (n > m) { // m 을 더 큰 수로.
            big = n;
            small = m;
        }

        while (true) {
            if (big % small == 0) {
                answer[0] = small;
                break;
            }
            int temp = big % small;

            big = small;
            small = temp;

        }

        answer[1] = n * m / answer[0];

        return answer;
    }

}