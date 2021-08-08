package Baekjoon;

import java.util.Scanner;

public class Baekjoon15649 { //백트래킹
    static StringBuilder sb = new StringBuilder();
    static boolean[] cnt = new boolean[8]; //사용한 값 체크
    static int[] rst = new int[8]; //출력할 수열 값 저장

    public  static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(); //최대값
        int n = sc.nextInt(); //수열사이즈

        go(0, m, n); //재귀
    }

    static void go(int index, int m, int n) {
        if (index == n) {
            for(int i=0; i<n; i++) {
                sb.append(rst[i] + " ");
            }
            System.out.println(sb);
            sb.setLength(0);
            return;
        }
        for(int i=0; i<m; i++) {
            if(cnt[i]) {
                continue;
            }
            cnt[i] = true;
            rst[index] = i+1;
            go(index+1, m, n);
            cnt[i] = false;
        }
    }
}
