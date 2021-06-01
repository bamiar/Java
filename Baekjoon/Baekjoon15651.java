package Baekjoon;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Baekjoon15651 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] rst = new int[7];

    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(); //자연수 최대값
        int n = sc.nextInt(); //수열 크기

        go(0, m, n);
        bw.flush(); //매번 flush 하기보다 1번만 해주는게 효율적, 여기서 시간초과남ㅠ
    }

    static void go(int idx, int m, int n) {
        if(idx == n) {
            try {
            for(int i=0; i<n; i++) {
                bw.write(rst[i] + " ");
            }
            bw.write("\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return;
        }
        for(int i=0; i<m; i++) {
            rst[idx] = i+1;
            go(idx+1, m, n);
        }
    }
}
