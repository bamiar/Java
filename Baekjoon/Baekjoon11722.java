package Baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon11722 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n+1];
        int[] d = new int[n+1];

        for (int i=1; i<=n; i++) {
            a[i] = sc.nextInt();
        }

        for(int i=1; i<=n; i++) {
            d[i] = 1;
            for(int j=1; j<i; j++) {
                if (a[j] > a[i] && d[j] +1 > d[i]) {
                    d[i] = d[j] +1;
                }
            }
        }

        System.out.println(Arrays.stream(d).max().getAsInt());
    }
}
