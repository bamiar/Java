package Programmers;

import java.util.ArrayList;

public class p42840 {
    static int[] p1 = {1,2,3,4,5};
    static int[] p2 = {2,1,2,3,2,4,2,5};
    static int[] p3 = {3,3,1,1,2,2,4,4,5,5};

    // public static void main(String[] args) {
    //     int[] input = {1,2,3,4,5};
    // }

    public static int[] solution(int[] answers) {
        int[] answer;
        int[] count = new int[3];

        for(int i=0; i<answers.length; i++) {
            if(answers[i] == p1[i%5]) {count[0]++;}
            if(answers[i] == p2[i%8]) {count[1]++;}
            if(answers[i] == p3[i%10]) {count[2]++;}
        }

        int maxCount = Math.max(Math.max(count[0], count[1]), count[2]);
        ArrayList<Integer> result = new ArrayList<>();

        for(int i=0; i<count.length; i++) {
            if (count[i]==maxCount) {
                result.add(i);
            }
        }

        answer = new int[result.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }

}
