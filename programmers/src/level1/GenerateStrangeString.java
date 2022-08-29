class Solution {
    public String solution(String s) {

        StringBuilder sb = new StringBuilder();

        boolean isOdd = true;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == ' ') {
                sb.append(" ");
                isOdd = true;
                continue;
            }

            if (isOdd) {
                sb.append(Character.toUpperCase(ch));
            }
            else if (!isOdd) {
                sb.append(Character.toLowerCase(ch));
            }

            isOdd = !isOdd;
        }

        return sb.toString();
    }
}