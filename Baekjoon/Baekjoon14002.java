package Baekjoon;

import java.util.Scanner;

public class Baekjoon14002 {
    static int[] a = new int[100001];
    static int[] d = new int[100001];
    static int[] v = new int[100001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int result = 1;
        int top = 0;

        for (int i=0; i<n; i++) {
            a[i] = sc.nextInt();
        }

        for(int i=0; i<n; i++) {
            d[i] = 1;
            v[i] = -1;
            for(int j=0; j<i; j++) {
                if(a[i] > a[j] && d[i] <= d[j]+1) {
                    d[i] =d[j]+1;
                    v[i] = j;
                }
            }
            if (result < d[i]) {
                result = d[i];
                top=i;
            }
        }
        System.out.println(result);
        go(top);
    }

    static void go(int p) {
        if (p==-1) {
            return;
        } go(v[p]);
        System.out.println(a[p] + " ");

    }
}