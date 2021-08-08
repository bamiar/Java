package Baekjoon;

import java.util.Scanner;

public class Baekjoon1934 { //최소공배수
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i=0; i<t; i++) {
            int a = sc.nextInt();
            int b= sc.nextInt();

            System.out.println(a*b/gcd(a,b));
        }
    }

    private static int gcd(int a, int b) { //유클리드호제법
        if (b==0) {
            return a;
        } else return gcd(b, a%b);
    }
}
