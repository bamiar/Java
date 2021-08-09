package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Edge { //두 자료형을 묶기 위해=> arraylist 안에 배열을 넣는게 불가능해서 클래스로 구현
    int from, to;
    Edge(int from, int to) {
        this.from = from;
        this.to = to;
    }
}
public class Baekjoon13023 { //dfs
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[]args) throws Exception{
        StringTokenizer st =  new StringTokenizer(br.readLine().trim());
        int n = Integer.parseInt(st.nextToken()); //친구의 수
        int m = Integer.parseInt(st.nextToken()); //관계의 수

        boolean[][] a = new boolean[n][n]; //인접행렬
        ArrayList<Integer>[] g = new ArrayList[n]; //인접리스트
        ArrayList<Edge> edges= new ArrayList<>();//간선리스트

        for(int i=0; i<n;i++) {
            g[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine().trim());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            a[from][to] = a[to][from] = true;
            g[from].add(to);
            g[to].add(from);
            edges.add(new Edge(from, to));
            edges.add(new Edge(to, from));
        }

        m *= 2; //간선의 개수를 2배 해주는 이유는 양방향이라서, 위 for문에서도 2번씩 저장함
        for (int i=0; i<m; i++) { //간선리스트를 처음부터 끝까지 탐색
            for(int j=0; j<m; j++) {
                int A = edges.get(i).from;
                int B = edges.get(i).to;
                int C = edges.get(j).from;
                int D = edges.get(j).to;
                if (A==B || A==C || A==D || B==C || B==D || C==D) { //정점이 겹치지 않는 두 간선을 구함
                    continue;
                }
                if (!a[B][C]) continue; //위에서 구한 두 간선의 끝-시작점의 인접여부를 확인
                for(int E : g[D]) { //인접리스트에서 D정점과 E정점 인접여부를 확인
                    if (A==E || B==E || C==E || D==E) continue;
                    System.out.println(1);
                    System.exit(0);
                }
            }
        }
        System.out.println(0);
    }
}
