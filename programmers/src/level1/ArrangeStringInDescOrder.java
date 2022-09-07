import java.util.*;
import java.util.stream.Stream;
import java.util.stream.Collectors;

class Solution {
    public String solution(String s) {

        return Stream.of(str.split(""))
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.joining());

//        String[] strArr = new String[s.length()];
//
//        for (int i = 0; i < s.length(); i++) {
//            strArr[i] = Character.toString(s.charAt(i));
//        }
//
//        String streamSortDESC = Stream.of(strArr)
//                .sorted(Comparator.reverseOrder())
//                .map(arr -> new String(arr))
//                .collect(Collectors.joining());
//
//        return streamSortDESC;
    }
}