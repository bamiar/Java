package Programmers;

import java.util.Arrays;
import java.util.Collections;

public class p42747 {

    public static void main(String[] args) {

        System.out.println(solution(new int[] {3, 0, 6, 1, 5}));
    }

    public static int solution(int[] citations) { //H-Index 틀림 ㅠ
        int answer = 0;

        Integer[] temp = Arrays.stream(citations).boxed().toArray(Integer[]::new);
        Arrays.sort(temp, Collections.reverseOrder());

        for(int i=0; i<temp.length; i++) {
            if(i+1<temp.length) {
                if(i+1>=temp[i] && temp.length-i<=i) {
                    answer = i;
                }
            }
         }

        return answer;
    }

}
