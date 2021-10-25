package Programmers;

public class p87946 {
    static int sum;
    static int[][] d;
    static boolean[] visited;

    public static void main(String[] arg) {
        solution(30,new int[][] {{10,10},{30,20}, {80,10},{70,1}, {1,1}});
//        solution(90,new int[][] {{100,20},{10,10},{50,40}, {80,10},{1,1}});
//        solution(80,new int[][] {{80,20},{50,40}, {30,10}});
    }

    public static int solution(int k, int[][] dungeons) {
        int answer = 0;
        d = dungeons;

        for(int i=0; i<dungeons.length; i++) {
            visited = new boolean[dungeons.length];
            sum = 0;
            if(dungeons[i][0] <=k && dungeons[i][1]<=k) {
                dfs(i, k,1);
                answer = answer<sum? sum:answer;
            }
        }

        return answer;
    }

    public static void dfs(int start, int k, int count) {
        if(visited[start]) return;

        visited[start] = true;
        k = k-d[start][1];
        sum = sum<count?count:sum;

        for(int i=0; i<d.length; i++) {
            if(!visited[i] && d[i][0]<=k && d[i][1]<=k) {
                dfs(i, k, count+1);
            }
        }
        visited[start] = false;
    }
}
