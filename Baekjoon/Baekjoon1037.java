package Baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon1037 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];

        for (int i=0; i<n; i++) {
            a[i] = sc.nextInt();
        }

        int max = Arrays.stream(a).max().getAsInt();
        int min = Arrays.stream(a).min().getAsInt();

        if (max==min) {
            System.out.println((int) Math.pow(max, 2));
        } else System.out.println(max * min);
    }
}
