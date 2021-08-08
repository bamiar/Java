package Baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class Baekjoon1707 { // 이분 그래프 dfs bfs
    private static final Scanner sc = new Scanner(System.in);
    private static ArrayList<Integer>[] adjust;
    private static int[] color;

    public static void main(String[] args) {
        int k = sc.nextInt();

        while(k-- >0) {
            int v = sc.nextInt(); //정점의 개수
            int e = sc.nextInt(); //간선의 개수

            adjust = new ArrayList[v+1];
            for (int i = 0; i < v+1; i++) {
                adjust[i] = new ArrayList<Integer>();
            }
            color = new int[v+1];

            for(int i=0; i<e; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                adjust[a].add(b);
                adjust[b].add(a);
            }

            boolean rst = true;
            for(int i=0; i<v; i++) {
                if(color[i] == 0) {
                    if(!dfs(i,1)) {
                        rst = false;
                    }
                }
            }

            System.out.println(rst?"YES":"NO");
        }
    }

    private static boolean dfs(int node, int c) { //순회 결과가 이분리스트이면 true 아니면 false 리턴
        //먼저 노드 방문, 색깔 변경
        color[node] = c;
        // 인접리스트에 있는 다음 노드 순회
        for(int i=0; i< adjust[node].size(); i++) {
            int next = adjust[node].get(i);
            //다음 노드가 미방문인 경우 -> dfs로 순회하여 걸과가 false면 false 리턴
            if(color[next]==0) {
                if(!dfs(next, 3-c)) { //다음 노드의 색깔 != 현재노드의 색깔이면 이분그래프
                    return false;
                }
            //다음노드가 방문인 경우 -> 색깔을 비교해서 둘이 같으면 false 리턴
            } else if (color[node] == color[next]) return false;
        }
        return true;
    }
}
