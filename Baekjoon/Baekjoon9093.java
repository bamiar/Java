package Baekjoon;
//https://www.acmicpc.net/problem/9093

import java.io.*;
import java.util.Stack;

public class Baekjoon9093 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        final int t = Integer.parseInt(bf.readLine());
        for (int i = 0; i < t; i++) {
            String input = bf.readLine();
            Stack<String> stack = new Stack<>();
            String[] word = input.split(" ");

            for (String w : word) {
                String[] chars = w.split("");

                for (String c : chars) {
                    stack.push(c);
                }
                while (!stack.empty()) {
                    bw.write(stack.pop());
                }
                bw.write(" ");
            }
            bw.write(" ");
            bw.flush();

        }
     bf.close();
    }
}
