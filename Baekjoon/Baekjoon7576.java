package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon7576 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int n;
    private static int m;
    private static int rst = 0;
    static boolean bfsCheck = false;
    private static int[][] square;
    private static Queue<int[]> queue = new LinkedList();
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0,0, -1, 1};

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        square = new int[n][m];

        for(int i=0; i<n; i++) {
            int[] input = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(a -> Integer.parseInt(a)).toArray();
            square[i] = input;
        }

        for(int i=0; i<n; i++) { //큐에 시작지점을 전부 추가해줌
            for(int j=0; j<m; j++) {
                if(square[i][j] == 1) {
                    queue.add(new int[] {i, j});
                }
            }
        }

        bfs();

        loopOut:
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(square[i][j]==0) {
                    rst = 0;
                    bfsCheck = true;
                    break loopOut;
                }
            }
        }

        if(!bfsCheck) {
            System.out.println(0);
        } else System.out.println(rst-1);
    }


    static void bfs() {
        while(!queue.isEmpty()) {
            int x = queue.peek()[0];
            int y = queue.peek()[1];
            queue.remove();

            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx>=0 && nx<n && ny>=0 && ny<m) {
                    if(square[nx][ny]==0) {
                        queue.add(new int[] {nx, ny});
                        square[nx][ny] = square[x][y] +1;

                        if(square[nx][ny] > rst) {
                            rst = square[nx][ny];
                        }
                        bfsCheck = true;
                    }
                }
            }
        }
    }
}
