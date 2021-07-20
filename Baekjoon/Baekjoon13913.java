package Baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Baekjoon13913 {
    private static final Scanner sc = new Scanner(System.in);
    private static boolean[] visit = new boolean[2000000]; //방문여부
    private static int[] dist = new int[2000000];  //소요시간
    private static int[] from = new int[2000000]; //방문경로
    private static final int max = 1000000;

    public static void main(String[] args) {
        int n = sc.nextInt(); //출발지점
        int k = sc.nextInt(); //목적지

        bfs(n, k);
//        backTracking(n, k);
        stackTracing(n, k);
    }

    static void bfs(int x, int y) {
        Queue<Integer> queue = new LinkedList();
        queue.add(x);
        visit[x] = true;

        while(!queue.isEmpty()) {
            x = queue.peek();
            if(x==y) break;
            queue.remove();

            if(x+1<max){
                if(!visit[x+1]) {
                    queue.add(x+1);
                    visit[x+1] = true;
                    from[x+1] = x;
                    dist[x+1] = dist[x]+1;
                }
            }
            if(x-1>=0) {
                if (!visit[x - 1]) {
                    queue.add(x - 1);
                    visit[x - 1] = true;
                    from[x-1] = x;
                    dist[x - 1] = dist[x] + 1;
                }
            }
            if(2*x < max) {
                if (!visit[2 * x]) {
                    queue.add(2 * x);
                    visit[2 * x] = true;
                    from[2 * x] = x;
                    dist[2 * x] = dist[x] + 1;
                }
            }
        }
        System.out.println(dist[x]);
    }

    //백트랙킹
    //결과값 -> -1, +1, /2 한것중에 dist[x] -1 과 값이 일치하면 선택
    //재귀로 풀기
//    static void backTracking(int n, int m) { //n은 시작점, m 은 종료지점
//        if(n!=m) {
//            backTracking(n,from[m]);
//        }
//
//        System.out.println(m + " ");
//    }

    //stack으로 풀기
    static void stackTracing(int n, int m) {
        Stack<Integer> stack = new Stack<>();

        for(int i=m; i!=n; i=from[i]) {
            stack.push(i);
        }
        stack.push(n);

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
