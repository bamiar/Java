package Baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon14226 { //bfs
    private static final Scanner sc = new Scanner(System.in);
    private static int[][] time; //0:방문안함 1이상:방문했으며 소요된시간

    public static void main(String[] args) {
        int s = sc.nextInt(); // 만들 이모티콘의 길이
        time = new int[s+1][s+1];

        System.out.println(bfs(1, s));
    }

    private static int bfs(int x, int s) {
        Queue<int[]> queue = new LinkedList<>();
        int y = 0;

        queue.add(new int[] {x, y});

        while(!queue.isEmpty()) {
            x = queue.peek()[0]; //화면의 이모티콘 길이
            y = queue.peek()[1]; //클립보드에 저장된 이모티콘 길이
            queue.remove();

            if(x==s) {break;}

            //클립보드에 이모티콘 복사
            if(x!=y) {
                int ny = x;
                if(time[x][ny]==0){
                    time[x][ny] = time[x][y]+1;
                    queue.add(new int[]{x, ny});
                }
            }

            //클립보드 내용 붙여넣기
            if(y>0) {
                int nx = x + y;
                if (nx <= s && time[nx][y] ==0) {
                    time[nx][y]= time[x][y]+1;
                    queue.add(new int[]{nx, y});
                }
            }
            //이모티콘 길이 -1
            if(x-1 >=0) {
                int nx = x-1;
                if(time[nx][y]==0) {
                    time[nx][y]= time[x][y]+1;
                    queue.add(new int[]{nx, y});
                }
            }
        }

        return time[x][y];
    }
}
