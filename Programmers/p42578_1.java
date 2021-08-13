package Programmers;

import java.util.HashMap;

public class p42578_1 {
    public static void main(String[] a) {
    solution(new String[][] {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}});
    }

    public static int solution(String[][] clothes) {

        HashMap<String, Integer> dress = new HashMap<>();

        for(int i=0; i<clothes.length; i++) {
            String type = clothes[i][1];
            if(dress.containsKey(type)) {
                dress.replace(type, dress.get(type)+1);
            } else {
                dress.put(type, 1);
            }
        }

        int answer = 1;

        for(int i : dress.values()) {
            answer *= i+1;
        }

        return answer-1;
    }
}
