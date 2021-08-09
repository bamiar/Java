package Baekjoon;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Baekjoon13549 { //bfs
    private final static Scanner sc = new Scanner(System.in);
    private static boolean[] visit = new boolean[100001];
    private static int[] time = new int[100001];

    public static void main(String[] args) {
        int n = sc.nextInt();
        int k = sc.nextInt();

        bfs(n, k);
    }

    private static void bfs(int start, int dest) {
        Deque<Integer> deque = new ArrayDeque();
        deque.addFirst(start);
        visit[start] = true;

        while(!deque.isEmpty()) {
            start = deque.pop();

            if(start==dest) {break;}

            for(int next : new int[] {start+1, start-1, start*2}) {
                if (0 <= next && next <= 100000) {
                    if(!visit[next]) {
                        visit[next] = true;

                        if(next!=start*2) {
                            deque.addLast(next);
                            time[next] = time[start]+1;
                        } else {
                            deque.addFirst((next));
                            time[next] = time[start];
                        }
                    }
                }
            }
        }
        System.out.println(time[dest]);
    }
}

//반례
//100000 0