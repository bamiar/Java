package Programmers;

import java.util.*;

public class p42586 {
    public static void main(String[] a) {
        solution(new int[] {93, 30, 55}, new int[] {1,30,5});
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        int n=progresses.length;
        int day = 1;
        int index = 0;

        Stack<Integer> stack =  new Stack();
        List<Integer> result = new ArrayList<>();
        
        
        for(int i=n-1; i>=0; i--) {
            stack.push(progresses[i]);
        }
        
        while(!stack.isEmpty()) {
            while(stack.peek() + (day * speeds[index]) <100) {
                day++;
            }

            int temp = 0;
            while(stack.peek()+ (day * speeds[index])>=100) {
                temp++;
                index++;
                stack.pop();

                if(stack.isEmpty()) {break;}
            }
            result.add(temp);
        }

        int[] answer = new int[result.size()];

        for(int i=0; i<result.size(); i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}
