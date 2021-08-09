package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Baekjoon11724 { //bfs dfs 연결요소
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static ArrayList<Integer>[] adjList;
    private static boolean[] check;
    private static int rst = 0;

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int n = Integer.parseInt(st.nextToken()); //정점의 개수
        int m = Integer.parseInt(st.nextToken()); //간선의 개수

        check = new boolean[n+1];

        adjList = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            adjList[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adjList[a].add(b);
            adjList[b].add(a);
        }

        for (int i = 0; i < n; i++) {
            Collections.sort(adjList[i]);
        }

        for(int i=1; i<check.length; i++) {
            if(check[i]) {
                continue;
            }
            dfs(i);
            rst++;
        }

        System.out.println(rst);
    }

    private static void dfs(int start) {
        if(check[start]) return;

        check[start] = true;
        for (int x : adjList[start]) {
            if(!check[x]) {
                dfs(x);
            }
        }
    }
}
