import java.util.StringTokenizer;

class Solution {

    boolean[][] reportCheck;
    int numOfUsers;

    public int[] solution(String[] id_list, String[] report, int k) {

        numOfUsers = id_list.length;

        // 신고 유무를 체크하는 boolean
        reportCheck = new boolean[numOfUsers][numOfUsers];

        StringTokenizer st;

        for (String str : report) {
            st = new StringTokenizer(str, " ");

            // 신고자 매칭
            String reporterId = st.nextToken();

            for (int i = 0; i < numOfUsers; i++) {
                if (id_list[i] == reporterId) { // 매칭이 된다면

                    String reporteeId = st.nextToken();
                    for (int j = 0; j < numOfUsers; j++) { // 피신고자 매칭
                        if (id_list[j] == reporteeId) {
                            reportCheck[i][j] = true;
                            break;
                        }
                    }
                }
            }

            // 피신고자 매칭
        }


        // answer 배열 길이 == id_list 길이
        int[] answer = {};
        return answer;
    }

    public static void CheckReport()


}