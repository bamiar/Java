package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Baekjoon10866 { //덱
    public static void main(String[] args) throws  Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> deque = new LinkedList<>();

        int input = Integer.parseInt(bf.readLine());
        while(input-- >0) {
            final String d = bf.readLine();
            if (d.startsWith("push_front")) {
                deque.addFirst(Integer.parseInt(d.substring(11)));
            } else if(d.startsWith("push_back")) {
                deque.addLast(Integer.parseInt(d.substring(10)));
            } else if(d.equals("pop_front")) {
                System.out.println(deque.isEmpty()?-1:deque.pollFirst());
            } else if(d.equals("pop_back")) {
                System.out.println(deque.isEmpty()?-1:deque.pollLast());
            } else if(d.equals("size")) {
                System.out.println(deque.size());
            } else if(d.equals("empty")) {
                System.out.println(deque.isEmpty()?1:0);
            } else if(d.equals("front")) {
                System.out.println(deque.isEmpty()?-1:deque.getFirst());
            } else if(d.equals("back")) {
                System.out.println(deque.isEmpty()?-1:deque.getLast());
            }
        }
    }
}
