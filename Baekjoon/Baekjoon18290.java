package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon18290 { //백트래킹
    static int n; //격자판 세로크기
    static int m; //격자판 가로크기
    static int k; //선택할 수
    static int answer = Integer.MIN_VALUE;
    static int[][] arr = new int[12][12];
    static boolean[][] visited = new boolean[12][12];
    final static int[] dx = {1,0,-1,0,0};
    final static int[] dy = {0,1,0,-1,0};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st1 = new StringTokenizer(s);

        n = Integer.parseInt(st1.nextToken());
        m = Integer.parseInt(st1.nextToken());
        k = Integer.parseInt(st1.nextToken());

        int sum = 0;

        for(int i=1; i<=n; i++) {
            String[] temp = br.readLine().split(" ");
            for(int j=1; j<=m; j++) {
                arr[i][j] = Integer.parseInt(temp[j-1]);
            }
        }

        go(1,1, k, sum);
        System.out.println(answer);

        br.close();
    }

    //열 진행은 오름차순으로 설정하고, 1행 안에서는 이전에 방문한 칸을 false 설정해서 스킵하도록 함
    private static void go(int px, int py, int cnt, int sum) {

        if (cnt==0) {
            answer = Math.max(answer, sum);
            return;
        }
        for(int i=px; i<=n; i++) {
            for (int j=(i==px?py:1); j<=m; j++) {
                if(!visit(i, j)) {continue;}

                visited[i][j] = true;
                go(i, j, cnt-1, sum + arr[i][j]);
                visited[i][j] = false;
            }
        }
    }

    private static boolean visit(int x, int y) { //인접한 칸 체크
        boolean result = true;
        for(int i=0; i<5; i++) {
            if(visited[dx[i]+x][dy[i]+y] == true) {
                result = false;
            }
        }
        return result;
    }
}
