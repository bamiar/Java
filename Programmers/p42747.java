package Programmers;

import java.util.*;

public class p42747 {

    public static void main(String[] args) {

        // System.out.println(solution(new int[] {3, 0, 6, 1, 5}));
        System.out.println(solution(new int[] {9,30,15,20,25}));
    }

    public static int solution(int[] citations) {
        int answer = 0;
        int n = citations.length;

        Arrays.sort(citations);

        for(int i=n-1; i>=0; i--) {
            if(n-i <= citations[i]) {
                answer++;
            } else break;
        }

        return answer;
    }

}
