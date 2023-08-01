public class PG_17683 { // [3차] 방금그곡
    public String solution(String m, String[] musicinfos) {
        // C#, D#, F#, G#, A# 변환
        m = convertSharp(m);

        StringBuilder sb = new StringBuilder();
        String answer = "(None)";
        int maxPlayTime = 0;
        for (String info : musicinfos) {
            sb.setLength(0); // sb 비우기
            String[] infos = info.split(","); // start, end, title, notes
            // 노트 변환
            infos[3] = convertSharp(infos[3]);
            int len = infos[3].length();
            // 시간차 만큼 반복 혹은 m 길이만큼
            int playTime = getTimeDiff(infos[0], infos[1]);
            if (playTime <= maxPlayTime) {
                continue;
            }
            for (int i = 0; i < playTime; i++) {
                sb.append(String.valueOf(infos[3].charAt(i % len)));
            }
            if (sb.toString().contains(m)) {
                if (maxPlayTime < playTime) {
                    answer = infos[2];
                    maxPlayTime = playTime;
                }
            }

        }
        return answer;
    }

    static String convertSharp(String note) {
        note = note.replaceAll("C#", "c");
        note = note.replaceAll("D#", "d");
        note = note.replaceAll("F#", "f");
        note = note.replaceAll("G#", "g");
        note = note.replaceAll("A#", "a");
        return note;
    }

    static int getTimeDiff(String start, String end) {
        // 12:10 13:06 (56분 차이)
        String[] startTime = start.split(":");
        String[] endTime = end.split(":");

        int hourDiff = Integer.valueOf(endTime[0]) - Integer.valueOf(startTime[0]);
        int minDiff = Integer.valueOf(endTime[1]) - Integer.valueOf(startTime[1]);

        return (hourDiff * 60) + minDiff;
    }

}
