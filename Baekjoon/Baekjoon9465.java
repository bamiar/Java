package Baekjoon;

import java.util.Scanner;

public class Baekjoon9465 { //다이나믹
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for(int i=0; i<t; i++) {
            int n = sc.nextInt();
            int[][] a = new int[n][3];
            int[][] d = new int[n][3];

            for(int j=0; j<n*2; j++) {
                if(j<n) {
                    a[j][0] = sc.nextInt();
                } else a[j-n][1] = sc.nextInt();
            }
            d[0][1] = a[0][0];
            d[0][2] = a[0][1];

            for (int j=1; j<n; j++) {
                d[j][0] = maxInt( d[j-1][0], d[j-1][1], d[j-1][2]);
                d[j][1] = Math.max(d[j-1][0], d[j-1][2]) + a[j][0];
                d[j][2] = Math.max(d[j-1][0], d[j-1][1]) + a[j][1];
            }

            System.out.println(maxInt( d[n-1][0], d[n-1][1], d[n-1][2]));
        }

    }

    static int maxInt(int a, int b, int c) {
        if (a>b) {
            return Math.max(a, c);
        } else return Math.max(b, c);
    }
}
