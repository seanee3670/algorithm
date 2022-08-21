class Solution {
    public String solution(String phone_number) {

        int lenPhoneNum = phone_number.length();

        // 전화번호가 4자리라면 바로 return
        if (lenPhoneNum == 4) {
            return phone_number;
        }


        String star = "****************"; // 별 최대 길이(16) = 전화번호 최대 길이(20) - 4
        int idxStar = lenPhoneNum - 4;


        return star.substring(0, idxStar) + phone_number.substring(idxStar, lenPhoneNum);
    }
}