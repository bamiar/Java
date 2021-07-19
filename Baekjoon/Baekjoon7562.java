package Baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon7562 {
    private static final Scanner sc = new Scanner(System.in);
    private static int n;
    private static int[][] board;
    private static int rst;
    private static int[] dx = {-2,-1,1,2,2,1,-1,-2};
    private static int[] dy = {1,2,2,1,-1,-2,-2,-1};

    public static void main(String[] args) {
        int t = sc.nextInt();
        while(t-->0) {
            n = sc.nextInt();
            board = new int[n][n];
            rst = 0;
            int startX = sc.nextInt();
            int startY = sc.nextInt();
            int destX = sc.nextInt();
            int destY = sc.nextInt();


            bfs(startX, startY, destX, destY);

            if(rst==0) {
                System.out.println(rst);
            } else System.out.println(rst-1);
        }
    }

    private static void bfs(int x, int y, int destX, int destY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});
        board[x][y] = 1;

        while(x!=destX || y!=destY) {
            x = queue.peek()[0];
            y = queue.peek()[1];
            queue.remove();

            for(int i=0; i<8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(0<=nx && nx<n && 0<=ny && ny<n) {
                    if(board[nx][ny] == 0) {
                        board[nx][ny] = board[x][y]+1;
                        queue.add(new int[] {nx, ny});
                        if(nx==destX && ny==destY) {
                            rst = Math.max(board[nx][ny], rst);
                        }
                    }
                }
            }
        }
        queue.clear();
    }
}

//반례
//3
//8
//0 0
//7 7
//15
//5 5
//6 6
//300
//0 0
//299 299