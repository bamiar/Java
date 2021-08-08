package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon2667 {//bfs dfs 사각형 안의 연결요소 구하기
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int[][] square;
    static int[][] check;
    static int rst = 0; //단지 번호
    static ArrayList<Integer> apts2 = new ArrayList(); // 단지별 크기
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws Exception{
        n = Integer.parseInt(br.readLine());
        square = new int[n][n];
        check = new int[n][n];

        for(int i=0; i<n; i++) {
            int[] s = Arrays.stream(br.readLine().split(""))
                    .mapToInt(a -> Integer.parseInt(a)).toArray();
            square[i] = s;
        }
        //시작지점 값이 1이면 bfs 시작 / 아니면 continue;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(check[i][j]==0 && square[i][j]==1){
                    bfs(i, j, ++rst);
                }
            }
        }

        Collections.sort(apts2);

        System.out.println(rst);
        for(int a : apts2) {
            System.out.println(a);
        }
    }

    static void bfs(int x, int y, int cnt) {
        Queue<int[]> queue = new LinkedList();
        queue.add(new int[] {x, y});
        check[x][y] = cnt;
        int counter = 1;

        while(!queue.isEmpty()) {
            x = queue.peek()[0];
            y = queue.peek()[1];
            queue.remove();

            //상하좌우 탐색
            for(int i=0; i<4; i++) {
                int nx = x+dx[i];
                int ny = y+dy[i];
                if (0<=nx && nx<n && 0<=ny && ny<n) {
                    if(square[nx][ny]==1 && check[nx][ny]==0) {
                        queue.add(new int[] {nx, ny});
                        check[nx][ny] = cnt;
                        counter++;
                    }
                }
            }
        }
        apts2.add(counter);
    }
}


