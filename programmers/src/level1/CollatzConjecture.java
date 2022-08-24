class Solution {
    public int solution(int num) {

        int count = 0;

        for (; count < 501; count++) {
            if (num == 1) {
                return count;
            }
            if (num % 2 == 0) {
                num = num / 2;
            }
            else if (num % 2 == 1) {
                num = num * 3 + 1;
            }
        }

        return -1;

    }
}