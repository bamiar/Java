package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon2178 { // 그래프, 최단거리, bfs
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int n;
    private static int m;
    private static int[][] square;
    private static int[][] check; //방문여부 표시
    private static int[][] dist; //거리
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0,0, -1, 1};
    private static int cnt;

    public static void main(String[] args) throws Exception{
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        square = new int[n][m];
        check = new int[n][m];
        dist = new int[n][m];

        for(int i=0; i<n; i++) {
            int[] input = Arrays.stream(br.readLine().split(""))
                    .mapToInt(a -> Integer.parseInt(a)).toArray();
            square[i] = input;
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(check[i][j]==0 && square[i][j]==1) {
                    bfs(i, j);
                }
            }
        }

        System.out.println(dist[n-1][m-1]);
    }

    static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList();
        queue.add(new int[] {x, y});
        check[x][y] = 1;
        dist[x][y] = 1;

        while(!queue.isEmpty()) {
                x = queue.peek()[0];
                y = queue.peek()[1];
                queue.remove();

            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx>=0 && nx<n && ny>=0 && ny<m) {
                    if(square[nx][ny]==1 && check[nx][ny]==0) {
                        queue.add(new int[] {nx, ny});
                        check[nx][ny] = 1;
                        dist[nx][ny] = dist[x][y] +1;
                    }
                }
            }
        }
    }
}
