package Baekjoon;

import java.util.Scanner;

public class Baekjoon15990 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextInt();
        long[][] d = new long[100001][4];
        d[3][3] = d[2][2] = d[1][1] = 1;
        d[3][1] = d[3][2] = 1;

        for (int i=4; i<=100000; i++) {
            d[i][1] = (d[i-1][3] + d[i-1][2]) % 1000000009;
            d[i][2] = (d[i-2][3] + d[i-2][1]) % 1000000009;
            d[i][3] = (d[i-3][2] + d[i-3][1]) % 1000000009;
        }

        while(t-- >0) {
            int n = sc.nextInt();
            System.out.println((d[n][1] +d[n][2] + d[n][3]) % 1000000009);
        }
    }
}
