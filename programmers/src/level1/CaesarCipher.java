class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (ch == ' ') {
                sb.append(' ');
            }
            else if (Character.isUpperCase(ch)) {

                ch = ch + n <= 'Z' ? (char) (ch + n) : (char) (ch + n - 26);
                sb.append(ch);
            }
            else if (Character.isLowerCase(ch)) {
                ch = ch + n <= 'z' ? (char) (ch + n) : (char) (ch + n - 26);
                sb.append(ch);
            }
        }
        return sb.toString();
    }

}