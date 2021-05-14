package Baekjoon;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        int[] a = new int[n];

        for (int i=0; i<n; i++) {
            a[i] = sc.nextInt();
        }


    }

    static int gcd(int a, int b) {
        if (a%b==0) {
            return b;
        } else return gcd(b, a%b);
    }
}
