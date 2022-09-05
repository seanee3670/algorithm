class Solution {
    boolean solution(String s) {

        int cntP = 0;
        int cntY = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == 'p' || ch == 'P') {
                cntP++;
            }
            else if (ch == 'y' || ch == 'Y') {
                cntY++;
            }
        }

        return  cntP == cntY ? true : false;
    }
}