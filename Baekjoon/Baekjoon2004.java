package Baekjoon;

import java.util.Scanner;

public class Baekjoon2004 { //팩토리얼
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long a = sc.nextInt();
        long b = sc.nextInt();
        int countTwo = (factorial(a,2) - factorial(a-b,2) - factorial(b,2));
        int countFive = (factorial(a,5) - factorial(a-b,5)- factorial(b,5));

        System.out.println(Math.min(countFive,countTwo));
    }

    static int factorial(long a, int n) {
        int counter = 0;
        for (long i = n; i<= a; i*=n) {
            counter+=a/i;
        }
        return counter;
    }
}
