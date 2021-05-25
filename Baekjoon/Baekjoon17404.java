package Baekjoon;

import java.util.Scanner;

public class Baekjoon17404 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[n+1][3];
        int[][] dp = new int[n+1][3];
        int ans = 1000*1000+1;

        for(int i=1; i<=n; i++) {
            for(int j=0; j<3; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        for(int i=0; i<=2; i++) { //시작값을 고정해서 색깔별로 n회 탐색
            for (int j=0; j<=2; j++) {
                if(i==j) {
                    dp[1][j] = a[1][j]; //현재 설정된 색깔로 1번집 칠하기
                } else dp[1][j] = 1000*1000+1; //초기값중 현재색깔 j로 칠하지 않는 부분은 예외처리
            }

            for (int j=2; j<=n; j++) { //1번에서
                dp[j][0] = Math.min(dp[j-1][1], dp[j-1][2]) +a[j][0];
                dp[j][1] = Math.min(dp[j-1][0], dp[j-1][2]) +a[j][1];
                dp[j][2] = Math.min(dp[j-1][1], dp[j-1][0]) +a[j][2];
            }

            for (int j=0; j<=2; j++) {
                if(i!=j && ans > dp[n][j]) {
                    ans = dp[n][j];
                }
            }
        }

        System.out.println(ans);
    }
}
