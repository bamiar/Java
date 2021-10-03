package Programmers;

import java.util.Arrays;

public class p12939 {
    public String solution(String s) {
        String answer = "";
        String[] S = s.split(" ");
        int size = S.length;
        int[] n = new int[size];

        for(int i=0; i<size; i++) {
            n[i] = Integer.valueOf(S[i]);
        }

        Arrays.sort(n);

        answer = answer.concat(String.valueOf(n[0]) + " ");
        answer = answer.concat(String.valueOf(n[size-1]));

        return answer;
    }
}
