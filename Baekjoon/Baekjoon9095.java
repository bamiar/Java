package Baekjoon;

import java.util.Scanner;

public class Baekjoon9095 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] d = new int[11];

        d[0] = d[1] = 1;
        d[2] = 2;
        d[3] = 4;
        while(t-- >0) {
            int n = sc.nextInt();
            for (int i = 2; i <= n; i++) {
                if(d[i]==0) {
                    d[i] = d[i-1] + d[i-2] + d[i-3];
                }
            }
            System.out.println(d[n]);
//            System.out.println(go(0, n)); 재귀로 풀 경우
        }
    }

//    static int go(int sum, int n) { //재귀함수로 푸는법
//        if (sum==n) return 1;
//        if (sum > n) return 0;
//        int result = 0;
//        for (int i=1; i<4; i++) {
//
//            result += go(sum+i, n);
//        }
//        return result;
//    }
}
