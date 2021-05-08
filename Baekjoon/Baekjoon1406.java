package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baekjoon1406 {
    public static void main(String[] args)throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Character> sl= new Stack<>();
        Stack<Character> sr = new Stack<>();

        String input = bf.readLine();
        for (int i=0; i < input.length(); i++) {
            sl.push(input.charAt(i));
        }

        int n = Integer.parseInt(bf.readLine());
        while(n-- >0) {
            String order = bf.readLine();

            if (order.equals("L")) {
                if(!sl.isEmpty()) {
                    sr.push(sl.pop());
                }
            } else if (order.equals("D")) {
                if(!sr.isEmpty()) {
                    sl.push(sr.pop());
                }
            } else if (order.equals("B")) {
                if(!sl.isEmpty()) {
                    sl.pop();
                }
            } else if (order.startsWith("P")) {
                sl.push(order.charAt(2));
            }
        }

        while(!sl.isEmpty()) {
            sr.push(sl.pop());
        }
        while(!sr.isEmpty()) {
            sb.append(sr.pop());
        }
        System.out.println(sb);

    }
}
