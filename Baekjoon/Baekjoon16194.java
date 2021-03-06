package Baekjoon;

import java.util.Scanner;

public class Baekjoon16194 { //다이나믹
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] p = new int[n+1];
        for (int i=1; i<n+1; i++) {
            p[i] = sc.nextInt();
        }

        int[] d = new int[n+1];
        for (int i=1; i<n+1; i++) {
            d[i] = 1000001;
        }

        for (int i=1; i<=n; i++) {
            for (int j=1; j<=i; j++) {
                int price = d[i-j] + p[j];
                if(d[i] >= price) { d[i] = price; }
            }
        }
        System.out.println(d[n]);

    }
}
