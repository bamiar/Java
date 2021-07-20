package Baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon1697 {
    private static final Scanner sc = new Scanner(System.in);
    private static boolean[] visit = new boolean[2000000]; //방문여부
    private static int[] dist = new int[2000000];  //소요시간
    private static final int max = 1000000;

    public static void main(String[] args) {
        int n = sc.nextInt(); //출발지점
        int k = sc.nextInt(); //목적지

        System.out.println(bfs(n, k));
    }

    static int bfs(int x, int y) {
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
                    dist[x+1] = dist[x]+1;
                }
            }
            if(x-1>=0) {
                if (!visit[x - 1]) {
                    queue.add(x - 1);
                    visit[x - 1] = true;
                    dist[x - 1] = dist[x] + 1;
                }
            }
            if(2*x < max) {
                if (!visit[2 * x]) {
                    queue.add(2 * x);
                    visit[x * 2] = true;
                    dist[2 * x] = dist[x] + 1;
                }
            }
        }
        return dist[x];
    }
}
