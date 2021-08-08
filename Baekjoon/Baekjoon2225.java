package Baekjoon;

import java.util.Scanner;

public class Baekjoon2225 { //다이나믹
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); //합해서 구할 정수
        int k = sc.nextInt(); //더해줄 정수의 종류 개수
        int[][] d = new int[n+1][k+1];

        for(int i=1;i<=n;i++) {
            d[i][1] = 1;
        }

        for(int i=1;i<=k;i++) {
            d[0][i] = 1;
            d[1][i] = i;
        }


        for (int n1=2; n1<=n; n1++) {
            for (int k1=2; k1<=k; k1++) {
                for (int l=0; l<=n1; l++) {
                    d[n1][k1] += d[n1-l][k1-1];
                    d[n1][k1] %=  1000000000;
                }
            }
        }

        System.out.println(d[n][k]);
        // l = 0~n
        //d[k][n] = sum(d[k-1][n-l])

    }
}
