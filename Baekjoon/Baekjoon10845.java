package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Baekjoon10845 {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> que = new LinkedList<>();
        int n = Integer.parseInt(bf.readLine());
        int q = -1;

        while(n-- >0) {
            String input = bf.readLine();

            if (input.startsWith("push")) {
                q =Integer.parseInt(input.substring(5));
                que.add(q);
            } else if(input.equals("pop")) {
                System.out.println(que.isEmpty()?-1:que.poll());
            } else if(input.equals("size")) {
                System.out.println(que.size());
            } else if(input.equals("empty")) {
                System.out.println(que.isEmpty()?1:0);
            } else if(input.equals("front")) {
                System.out.println(que.isEmpty()?-1:que.peek());
            } else if(input.equals("back")) {
                System.out.println(que.isEmpty()?-1:q);
            }
        }

    }
}
