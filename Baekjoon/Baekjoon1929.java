package Baekjoon;

import java.util.Scanner;

public class Baekjoon1929 { //소수구하기
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        boolean[] e = new boolean[n+1];
        e[0] = e[1] = true;

        //체 알고리즘
      for(int i=2; i<=Math.sqrt(n); i++) {
          if(e[i]) {continue;}
          for (int j=i+i; j<=n; j+=i) {
              e[j] = true;
          }
      }

        for (int i=m; i<=n; i++) {
            if (!e[i]) {
                System.out.println(i);
            }
        }
        sc.close();
    }
}
