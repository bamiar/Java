package Programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class p49189 {
    static boolean[] visited;
    static ArrayList<Integer>[] adj;

    public static void main(String[] a) {
        solution(6, new int[][] {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}});
    }

    public static int solution(int n, int[][] edge) {
        visited = new boolean[n+1];
        adj = new ArrayList[n+1];

        for(int i=0; i<adj.length; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int i=0; i<edge.length; i++) {
            adj[edge[i][0]].add(edge[i][1]);
            adj[edge[i][1]].add(edge[i][0]);
        }

        visited[1] = true;

        return dfs(1);
    }

    private static int dfs(int start) {
        class counter{
            int index, dist;
            counter(int index, int dist) {
                this.index = index;
                this.dist = dist;
            }
        }

        Queue<counter> queue = new LinkedList<>();
        queue.add(new counter(start, 0));
        visited[start] = true;
        int maxDist = -1;
        int maxCount = -1;

        while(!queue.isEmpty()) {
            int x = queue.peek().index;
            int c = queue.peek().dist;
            queue.poll();

            if(maxDist < c) {
                maxDist = c;
                maxCount = 1;
            } else if(maxDist==c) {
                maxCount++;
            }

            for(int y : adj[x]) {
                if(!visited[y]) {
                    queue.add(new counter(y,c+1));
                    visited[y] = true;
                }
            }
        }
        return maxCount;
    }
}
