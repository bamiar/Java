package Programmers;

import java.util.*;

public class p68644 {
    public static void main(String[] a) {
        solution(new int[] {2,1,3,4,1});
    }

    public static int[] solution(int[] numbers) {
        HashSet<Integer> sum = new HashSet<Integer>();

        for(int i=0; i< numbers.length; i++) {
            for(int j=i; j<numbers.length; j++) {
                if(i==j) continue;
                sum.add(numbers[i]+ numbers[j]);
            }
        }

        List<Integer> result = new ArrayList<>(sum);
        Collections.sort(result);

        int[] answer = new int[result.size()];
        for(int i=0; i<result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }

}
