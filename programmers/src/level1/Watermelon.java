class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();

        if (n % 2 == 0) {
            n /= 2;
            while (n-- > 0) {
                sb.append("수박");
            }
        }

        else if (n % 2 != 0) {
            sb.append("수");
            n /= 2; // 소숫점 이하 자리는 없어짐
            while (n-- > 0) {
                sb.append("박수");
            }
        }

        return sb.toString();

    }
}