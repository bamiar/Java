package Test;

import java.util.Deque;
import java.util.LinkedList;

public class pPFRS1_1 {
    public static void main(String[] arg) {
        solution(new int[] {1}, new int[] {2}); //3개정도 틀림
    }

    public static boolean solution(int[] arrA, int[] arrB) {
        Deque<Integer> deque = new LinkedList();

        for(int i=0; i< arrA.length; i++) {
            deque.add(arrA[i]);
        }

        Deque<Integer> cases = deque;
        boolean checker = false;

        for(int i=0; i<arrA.length; i++) {
            if(i!=0) {
                int temp = deque.poll();
                deque.addLast(temp);
            }

            Deque<Integer> case1 = cases;

            for(int j=0; j< arrB.length; j++) {
                if(case1.peek()==arrB[j]) {
                    case1.poll();
                    if(j==arrB.length-1) {
                        checker = true;
                    }
                } else break;
            }
            if (checker) {break;}
        }
        boolean answer = checker;
        return answer;
    }
}
