package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baekjoon17425 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        long[] d = new long[1000001];
        for (long i=1; i<1000001; i++) {
            for (long j = 1; i*j<1000001; j++) {
                int temp = Integer.valueOf((int) (i*j));
                d[temp] += i;
            }
        }

        long[] g = new long[1000001];
        for(int i=1; i<1000001; i++) {
            g[i] = g[i-1] + d[i];
        }

        while (n-- >0) {
            int i = Integer.parseInt(br.readLine());
            bw.write(g[i] +"\n");
        }
        bw.flush();
    }
}
