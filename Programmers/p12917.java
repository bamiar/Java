package Programmers;

import java.util.Arrays;

public class p12917 {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        String[] order = s.split("");

        Arrays.sort(order);
        
        for(int i=order.length-1; i>=0; i--) {
            sb.append(order[i]);
        }

        return sb.toString();
    }
}
