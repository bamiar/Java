package Programmers;

import java.util.Arrays;

class p42576 {
    public static void main(String[] a) {
        solution(new String[] {"leo", "kiki", "eden"}, new String[] {"eden", "kiki"});
    }

    public static String solution(String[] participant, String[] completion) {
        String answer = "";

        Arrays.sort(participant);
        Arrays.sort(completion);

        for(int i=0; i<participant.length; i++) {
            if(i>=completion.length || !participant[i].equals(completion[i])) {
                answer = participant[i];
                break;
            }
        }

        return answer;
    }
}