package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baekjoon1918 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        final char[] input = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();

       for(char c : input) {
            if (Character.isAlphabetic(c)) {
                sb.append(c);
            } else {
                if(Character.toString(c).equals(("("))) {
                    stack.push(c);
                } else if (Character.toString(c).equals((")"))) {
                    while(priority(stack.peek())!=0) {
                        sb.append(stack.pop());
                    }
                    stack.pop();
                } else if (stack.empty()) {
                    stack.push(c);
                } else {
                    if (priority(c) > priority(stack.peek())) {
                        stack.push(c);
                    } else {
                        while(!stack.isEmpty() && priority(c) <= priority(stack.peek())) {
                            sb.append(stack.pop());
                        }
                        stack.push(c);
                    }
                }
            }
        }

        while(!stack.isEmpty()) {
                sb.append(stack.pop());
        }
        System.out.println(sb);
    }

    public static int priority(char c) {
        String input = Character.toString(c);
        if (input.equals("(")) {
            return 0;
        } else if (input.equals("+") || input.equals("-")) {
            return 1;
        } else return 2;
    }
}

