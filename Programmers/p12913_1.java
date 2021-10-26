package Programmers;

public class p12913_1 {
    public static int solution(int[][] land) {
        int n = land.length;
        int[][] sum = new int[n][4];

        sum[0][0] = land[0][0];
        sum[0][1] = land[0][1];
        sum[0][2] = land[0][2];
        sum[0][3] = land[0][3];

        for(int i=1; i< n; i++) {
            sum[i][0] = land[i][0] + Math.max(Math.max(sum[i-1][1], sum[i-1][2]), sum[i-1][3]);
            sum[i][1] = land[i][1] + Math.max(Math.max(sum[i-1][0], sum[i-1][2]), sum[i-1][3]);
            sum[i][2] = land[i][2] + Math.max(Math.max(sum[i-1][0], sum[i-1][1]), sum[i-1][3]);
            sum[i][3] = land[i][3] + Math.max(Math.max(sum[i-1][0], sum[i-1][1]), sum[i-1][2]);
        }

        int answer = Math.max( Math.max(sum[n-1][0], sum[n-1][1]), Math.max(sum[n-1][2], sum[n-1][3]));

        return answer;
    }
}
