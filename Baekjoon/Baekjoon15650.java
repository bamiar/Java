package Baekjoon;

import java.util.Scanner;

public class Baekjoon15650 {//백트래킹
    static StringBuilder sb = new StringBuilder();
//    static boolean[] cnt = new boolean[8]; //사용한 값 체크
    static int[] rst = new int[8]; //출력할 수열 값 저장

    public  static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(); //최대값
        int n = sc.nextInt(); //수열사이즈

        go(0, 1, m, n); //재귀
    }

    static void go(int index, int start, int m, int n) {
        if (index == n) {
            for(int i=0; i<n; i++) {
                sb.append(rst[i] + " ");
            }
            System.out.println(sb);
            sb.setLength(0);
            return;
        }


        for(int i=start; i<=m; i++) {
//            if(cnt[index]) {
//                continue;
//            } else
//                cnt[index] = true;
                rst[index] = i;
                go(index+1, i+1, m, n);
//                cnt[index] = false;
        }
    }
}