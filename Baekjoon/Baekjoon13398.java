package Baekjoon;

import java.util.Scanner;

public class Baekjoon13398 { //다이나믹
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int n = sc.nextInt();
        final int[] a = new int[n+1];
        int[] d = new int[n+1];
        int[] dr = new int[n+1];

        for(int i=1; i<=n; i++) {
            a[i] = sc.nextInt();
        }

        for(int i=1; i<=n; i++) {
            d[i] = a[i];
            if(d[i-1] + a[i] > a[i]) {
                d[i] = d[i-1] + a[i];
            }
        }

        for(int i=n;i>=1; i--) {
            dr[i] = a[i];
            if (i==n) continue;
            if(dr[i] < dr[i+1] + a[i]) {
                dr[i] = dr[i+1] + a[i];
            }
        }

        int ans = -1001;

        for(int i=1; i<=n; i++) {
            if (ans < d[i]) {
                ans = d[i];
            }
        }

        for (int i=1; i<n; i++) {
            if(ans < d[i-1] + dr[i+1]) {
                ans = d[i-1] + dr[i+1];
            }
        }

        System.out.println(ans);
    }
}
