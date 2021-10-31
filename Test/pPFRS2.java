package Test;

import java.util.HashMap;
import java.util.Map;

public class pPFRS2 {
    public static void main(String[] arg) {
//        solution(new int[] {7, -5, -5, -5, 7, -1, 7}); //100100100100
        solution("abebeaedeac");
    }

    public static int solution(String s) {
        int answer = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (Character key : map.keySet()) {
            if (map.get(key) % 2 == 1) {
                ++answer;
            }
        }

        return answer;
    }
}
