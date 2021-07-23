package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Baekjoon1261 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[][] algospot;
    private static int[][] dist;
    private static boolean[][] visit;
    private static int n;
    private static int m;
    private static final int[] dx = {0,0,1,-1};
    private static final int[] dy = {1,-1,0,0};

    public static void main(String[] args) throws Exception{
        //시작점은 1, 1 고정
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        algospot = new int[n][m];
        dist = new int[n][m];
        visit = new boolean[n][m];

        for(int i=0; i<n; i++) {
            int[] in = Arrays.stream(br.readLine().split("")).mapToInt(a ->Integer.parseInt(a)).toArray();
            algospot[i] = in;
        }


        bfs(0, 0, n-1, m-1);
    }

    private static void bfs(int x, int y, int destX, int destY) {
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[] {x, y});
        visit[x][y] = true;

        while(!deque.isEmpty()) {
            x = deque.getFirst()[0];
            y = deque.getFirst()[1];
            deque.pop();

            if(x==destX && y==destY) {break;}

            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx>=0 && nx < n && ny>=0 && ny<m) {
                    if(!visit[nx][ny]) {
                        visit[nx][ny] = true;

                        if(algospot[nx][ny]==0) {
                            deque.addFirst(new int[] {nx, ny});
                            dist[nx][ny] = dist[x][y];
                        } else {
                            deque.addLast(new int[] {nx, ny});
                            dist[nx][ny] = dist[x][y]+1;
                        }
                    }
                }
            }
        }
        System.out.println(dist[x][y]);
    }
}
