package Baekjoon;

import java.util.Scanner;

public class Baekjoon11053 { //다이나믹
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] d = new int[n];

        for (int i=0; i<n; i++) {
            a[i] = sc.nextInt();
        }

        int result = 0;
        for(int i=0; i<n; i++) {
            d[i] = 1;
            for(int j=0; j<n; j++) {
                if(a[i] > a[j] && d[i] < d[j]+1) {
                    d[i] =d[j]+1;
                }
            }
            if (result < d[i]) {result = d[i];}
        }
        System.out.println(result);
    }
}
