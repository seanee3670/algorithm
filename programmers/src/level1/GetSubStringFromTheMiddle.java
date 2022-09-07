class Solution {
    public String solution(String s) {

        String answer = "";
        int midLen = s.length() / 2;

        if (s.length() % 2 == 1) {
            answer = s.substring(midLen, midLen + 1); // 가운데 글자만 출력
        }
        else if (s.length() % 2 == 0) {
            answer = s.substring(midLen - 1, midLen + 1); // 가운데 글자와 그 전 글자 출력
        }

        return answer;
    }
}