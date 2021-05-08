package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baekjoon17413 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        String[] input = br.readLine().split("");
        int size = 0;
        boolean tag = false;

        for(String i : input) {


            if (i.equals("<")) {
                tag = true;
                size = stack.size();
                for (int s=0; s<size; s++) {
                    sb.append(stack.pop());
                }
            }

            if (tag) {
                sb.append(i);
            } else {
                if (i.equals(" ")) {
                    size = stack.size();
                    for (int s=0; s<size; s++) {
                        sb.append(stack.pop());
                    } sb.append(i);
                } else {
                    stack.add(i);
                }
            }
            if (i.equals(">")) {
                tag = false;
            }
        }

        size = stack.size();
        for (int s=0; s<size; s++) {
            sb.append(stack.pop());
        }
        System.out.println(sb);
    }
}
