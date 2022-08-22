class Solution {
    public boolean solution(int x) {

        int sumDigits = 0;
        int temp = x;

        while (temp > 0) {
            sumDigits += temp % 10;
            temp /= 10;
        }

        return x % sumDigits == 0;
    }
}