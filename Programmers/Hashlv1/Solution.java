package Programmers.Hashlv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    public String solution(String[] participant, String[] completion) {
        List<String> part = new ArrayList(Arrays.asList(participant.clone()));
        List<String> comp = new ArrayList(Arrays.asList(completion.clone()));

        String answer = "";
        int i = 0;

        Collections.sort(part);
        Collections.sort(comp);
        comp.add("");

        for (String s : part) {
            if (s.equals(comp.get(i))) {
                i++;
            }
            else answer = s;
        }
        return answer;
    }
}