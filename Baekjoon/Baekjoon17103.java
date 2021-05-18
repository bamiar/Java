package Baekjoon;

import java.util.Scanner;

public class Baekjoon17103 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean[] isNotPrime = new boolean[1000001];
        isNotPrime[0] = isNotPrime[1]=true;

        for(int i=2; i<1000001; i++) {
            if(isNotPrime[i]) continue;
            else {
                for(int j=i+i; j<1000000; j+=i) {
                    isNotPrime[j] = true;
                }
            }
        }

        int t = sc.nextInt();
        int counter = 0;

        while (t-- >0) {
            int n = sc.nextInt();
            boolean[] gbp = new boolean[n+1];
            for(int i=2; i<n; i++) {
                if (!isNotPrime[i] && !isNotPrime[n-i]) {
                    gbp[i]=true;
                    if(!gbp[n-i] || i == n-i) counter++;
                }
            }
            System.out.println(counter);
            counter=0;
        }


    }
}
