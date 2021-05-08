package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baekjoon10799 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("");
        Stack<Integer> stack = new Stack<>();
        int result = 0;

        for(int i=0; i<input.length; i++) {
            if(input[i].equals("(")) {
                stack.add(i);
            } else if(input[i].equals(")") && i-1==stack.peek()) {
                stack.pop();
                result = result + stack.size();
            } else if(input[i].equals(")") && i!=stack.peek()) {
                stack.pop();
                result = result + 1;
            }
        }
        System.out.println(result);

    }
}
