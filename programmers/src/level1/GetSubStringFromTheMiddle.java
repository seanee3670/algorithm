class Solution {
    public String solution(String s) {
        // 5 -> 2
        // 4 -> 1, 2
        return s.substring((s.length() - 1) / 2, (s.length() / 2) + 1);
    }
}