import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

class Solution {
    public long solution(long n) {

        ArrayList<Long> arrList = new ArrayList<>();

        while(n > 0) {
            arrList.add(n % 10);
            n /= 10;
        }

        Collections.sort(arrList);
        Iterator<Long> iter = arrList.iterator();

        Long answer = 0L;
        for (int digit = 1; iter.hasNext(); digit *= 10) {
            answer += iter.next() * digit;
        }

        return answer;
    }
}