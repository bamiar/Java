package Baekjoon;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon15654 { //백트래킹
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] arr;
    static boolean[] count = new boolean[10001];
    static int[] result = new int[8];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //자연수 개수
        int m = sc.nextInt(); // 수열 길이
        arr = new int[n];

        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        arr = Arrays.stream(arr).sorted().toArray();

        //재귀함수 call
        go(0, n, m);
    }

    static void go(int index, int n, int m) {
        //index : 값을 채워넣을 result 수열 위치
        //n 자연수 개수
        //m 수열 길이
        if(index ==m) {
            //result 출력
            try {
                for(int i=0; i<m; i++) {
                    bw.write(result[i] + " ");
                }
                bw.write("\n");
                bw.flush();
                return;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return;
        }

        for(int i=0; i<n; i++) {
            if(count[arr[i]]) {
                continue;
            }
            result[index] = arr[i];
            count[arr[i]] = true;
            go(index+1, n, m);
            count[arr[i]] = false;
        }
    }
}
