package Programmers;

import java.util.Stack;

public class P12909 {
    static boolean solution(String s) {
        boolean answer = true;
        Stack<String> stack = new Stack<>();

        for(int i=0; i<s.length(); i++) {
            if(String.valueOf(s.charAt(i)).equals("(")) {
                stack.push("(");
            } else if(stack.isEmpty() && String.valueOf(s.charAt(i)).equals(")")) {
                answer = false;
                break;
            } else {
                stack.pop();
            }
        }

        if(!stack.isEmpty()) {
            answer = false;
        }

        return answer;
    }
}
