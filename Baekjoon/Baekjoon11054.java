package Baekjoon;

import java.util.Scanner;

public class Baekjoon11054 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n+1];
        int[] dAsc = new int[n+1]; //증가하는 부분수열 길이
        int[] dDesc = new int[n+1]; // 감소하는 부분수열 길이

        for(int i=1; i<=n; i++) {
            a[i] = sc.nextInt();
        }

        dAsc[1] = 1;
        for (int i=2; i<=n; i++) {
            dAsc[i] = 1;
            for(int j=1; j<i; j++) {
                if(a[j] < a[i] && dAsc[j]+1 > dAsc[i] ) {
                    dAsc[i] = dAsc[j] +1;
                }
            }
        }

        for(int i=n; i>=1; i--) {
            dDesc[i] = 1;
            for(int j=i+1; j<=n; j++) {
                if (a[j] < a[i] && dDesc[j] +1 > dDesc[i]) {
                    dDesc[i] = dDesc[j] +1;
                }
            }
        }

        int ans = 0;
        for(int i=1; i<n; i++) {
            if(ans < dDesc[i] + dAsc[i] -1) {
                ans = dDesc[i] + dAsc[i]-1;
            }
        }

        if(n==1) {
            System.out.println(1);
        } else System.out.println(ans);
    }
}
