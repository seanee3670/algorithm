import java.util.Arrays;

class MarathonRunners {
    public String solution(String[] participant, String[] completion) {
        StringBuilder sb = new StringBuilder();

        for (String winner : completion) {
            if (!Arrays.asList(participant).contains(winner)) {
                sb.append(winner + " ");
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};

        System.out.println(solution(participant, completion));

}