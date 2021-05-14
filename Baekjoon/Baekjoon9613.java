package Baekjoon;

import java.util.Scanner;

public class Baekjoon9613 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- >0) {
            long result = 0;
            int n = sc.nextInt();
            int[] inputs = new int[n];
            for (int i = 0; i < n; i++) inputs[i] = sc.nextInt();

            for (int i = 0; i < inputs.length - 1; i++) {
                for (int j = i + 1; j < inputs.length; j++) {
                    result += gcd(inputs[i], inputs[j]);
                }
            }
            System.out.println(result);
        }}

    static int gcd(int a, int b) {
//        return b==0? a:gcd(b, a%b);
        if (a%b==0) {
            return b;
        } else return gcd(b, a%b);
    }
}
