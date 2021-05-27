package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baekjoon10989 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int[] cnt = new int[10001];
        int[] result = new int[n];

        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            cnt[arr[i]]++;
        }

        for(int i=1; i<cnt.length; i++) { //카운팅 정렬
            cnt[i] += cnt[i-1];
        }

        for(int i=n-1; i>=0; i--) {
            int value = arr[i];
            result[--cnt[value]] = value;
        }

        for(int i : result) {
            bw.write(i+"\n");
        }
        bw.flush();
    }
}
