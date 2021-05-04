package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//https://www.acmicpc.net/problem/10828


class Baekjoon10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();

        final int input = Integer.parseInt(br.readLine());
        for (int i = 0; i < input; i ++) {
            String order = br.readLine();
            if (order.startsWith("push")) {
                String[] p = order.split(" ");
                stack.push(Integer.parseInt(p[1]));
            }

            switch (order) {
                case ("pop") :
                    if (stack.empty()) {
                        System.out.println(-1);
                    } else System.out.println(stack.pop());
                    break;
                case("size") :
                    System.out.println(stack.size());
                    break;
                case("empty") :
                    int e = 0;
                    if (stack.empty()) {
                        e++;
                    }
                    System.out.println(e);
                    break;
                case("top") :
                    if (stack.size() == 0) {
                        System.out.println(-1);
                    } else System.out.println(stack.peek());
                    break;
            }
        }
        br.close();

    }
}
