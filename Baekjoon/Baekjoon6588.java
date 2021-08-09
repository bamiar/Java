package Baekjoon;

import java.util.Scanner;

public class Baekjoon6588 {//소수 에라토스테네스의 체
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean[] prime = new boolean[1000001];
        prime[0]=prime[1]=true;
        for(int i=2; i<=Math.sqrt(1000000); i++) {
            if(!prime[i]) {
                for(int j=i+i; j<=1000000; j+=i) {
                    prime[j] = true;
                }
            }
        }

        int n = sc.nextInt();
        while(n!=0) {
            boolean pass = false;
            for(int b=3; b<n;b+=2) {
                if(!prime[n-b] && !prime[b]) {
                    System.out.println(n + " = " +  b + " + " + (n-b));
                    pass = true;
                    break;
                }
            }

            if (!pass) {
                System.out.println("\"Goldbach's conjecture is wrong.\"");
            }

            n=sc.nextInt();
        }
        sc.close();
    }
}
