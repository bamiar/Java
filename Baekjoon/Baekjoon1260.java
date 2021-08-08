package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon1260 { //dfs bfs
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static ArrayList<Integer>[] adjList;
    private static boolean[] check;

    public static void main(String[] args) throws Exception{
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int n = Integer.parseInt(st.nextToken()); //정점의 개수
        int m = Integer.parseInt(st.nextToken()); //간선의 개수
        int v =  Integer.parseInt(st.nextToken()); // 탐색시작점

        adjList = new ArrayList[n+1];
        for (int i=0; i<n+1; i++) {
            adjList[i] = new ArrayList<Integer>();
        }

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adjList[a].add(b);
            adjList[b].add(a);
        }

        for(int i=0; i<=n; i++) {
            Collections.sort(adjList[i]);
        }

        check = new boolean[n+1];
        dfs(v);
        System.out.println();

        check = new boolean[n+1];
        bfs(v);
        System.out.println();
    }


    public static void dfs(int x) {
        if(check[x]) return;

        check[x] = true;
        System.out.print(x + " ");
        for (int y : adjList[x]) {
            if(!check[y]) {
                dfs(y);
            }
        }
    }

    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(start);
        check[start] = true;

        while(!q.isEmpty()) {
            int x = q.remove();
            System.out.print(x + " ");
            for (int y : adjList[x]) {
                if(!check[y]) {
                    check[y] = true;
                    q.add(y);
                }
            }
        }
    }
}
