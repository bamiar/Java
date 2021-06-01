package Baekjoon;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Baekjoon15652 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] rst = new int[8];

    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);

        int n = sc.nextInt(); //최대 자연수
        int m = sc.nextInt(); // 수열 길이

        go(0, n ,m, 1);
    }

    static void go(int idx, int n, int m, int start) { //인덱스, 최대자연수, 수열길이, 시작지점
        if(idx == m) {
            try {
            for(int i=0; i<m; i++) {
                bw.write(rst[i] + " ");
            }
            bw.write("\n");
            bw.flush();
            return;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        for(int i=start; i<=n; i++) {
            rst[idx] = i;
            go(idx+1, n, m, i);
        }
    }
}
