package Baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon1912 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] d = new int[n];

        for (int i=0; i<n; i++) {
            a[i] = sc.nextInt();
        }

        for(int i=0; i<n; i++) {
            d[i] = a[i];
            if(i==0) continue;
            if(d[i-1] +a[i] > d[i]) {
                d[i] = d[i-1] +a[i];
            }
        }

        System.out.println(Arrays.stream(d).max().orElseThrow());
    }
}
