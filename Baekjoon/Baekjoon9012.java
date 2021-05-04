//https://www.acmicpc.net/problem/9012
package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Baekjoon9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        final int input = Integer.parseInt(bf.readLine());
        for (int i = 0; i <  input; i++) {
            String[] ps = bf.readLine().split("");
            Stack<String> stack1 = new Stack<>();
            String answer = "YES";

            for (String p : ps) {
                switch (p) {
                    case ("(") :
                        stack1.push(p);
                        break;
                    case(")") :
                        if (stack1.size() == 0) {
                            answer = "NO";
                        } else if (stack1.get(stack1.size()-1).equals("(")) {
                          stack1.pop();
                        } else answer = "NO";
                        break;
                }
            }
            if (stack1.size() != 0) {answer = "NO";}
            System.out.println(answer);
            answer = "YES";
        }

        bf.close();
    }
}
