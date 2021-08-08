package Baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon11055 { //다이나믹
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n+1];
        int[] d = new int[n+1];

        for (int i=1; i<=n; i++) {
            a[i] = sc.nextInt();
        }

        d[1] = a[1];

        for (int i=2; i<=n; i++) {
            d[i] = a[i];
            for(int j=1; j<i; j++) {
                if(a[i] > a[j] && d[i] < d[j] + a[i]) {
                    d[i] = d[j] + a[i];
                }
            }
        }

        System.out.println(Arrays.stream(d).max().getAsInt());
    }
}
