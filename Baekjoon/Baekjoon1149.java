package Baekjoon;

import java.util.Scanner;

public class Baekjoon1149 { //다이나믹
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] price = new int[n+1][3];
        int[][] d = new int[n+1][3];

        for(int i=1; i<=n; i++) {
            price[i][0] = sc.nextInt();
            price[i][1] = sc.nextInt();
            price[i][2] = sc.nextInt();
        }

        for(int i=1; i<=n; i++) {
            for (int j=0; j<=2; j++) {
                if (j==0) {
                    d[i][j] = Math.min(d[i-1][1], d[i-1][2]) + price[i][j]; }
                else if(j==1) {
                    d[i][j] = Math.min(d[i-1][0], d[i-1][2]) + price[i][j]; }
                else if(j==2) {
                    d[i][j] = Math.min(d[i-1][0], d[i-1][1]) + price[i][j];
                }
            }
        }
        System.out.println(Math.min(d[n][0], Math.min(d[n][1], d[n][2])));
    }
}
