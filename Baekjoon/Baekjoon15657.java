package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon15657 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int[] sortedArr; //input 오름차순으로 정렬
    static int[] result = new int[8];

    public static void main(String[] args) throws Exception{
        String s = br.readLine();
        StringTokenizer st1 = new StringTokenizer(s);

        int n = Integer.parseInt(st1.nextToken()); //자연수 개수
        int m = Integer.parseInt(st1.nextToken()); // 수열 길이
        int[] input = new int[n];

        s = br.readLine();
        StringTokenizer st2 = new StringTokenizer(s);
        for(int i=0; i<n; i++) {
            input[i] = Integer.parseInt(st2.nextToken());
        }

        int[] count = new int[10001]; //카운팅 정렬용
        sortedArr = new int[n];

        for(int i=n-1; i>=0; i--) {
            count[input[i]]++;
        }
        for(int i=1; i<count.length; i++) {
            count[i] +=count[i-1];
        }
        for(int i=n-1; i>=0; i--) {
            sortedArr[count[input[i]]-1] = input[i];
        }

        //재귀함수 call
        go(0, 0, n, m);

        System.out.println(sb);
    }


    static void go(int index, int start, int n, int m) {
        //index : 값을 채워넣을 result 수열 위치
        //n 자연수 개수
        //m 수열 길이
        if(index ==m) {
            //result 출력
            for(int i=0; i<m; i++) {
                sb.append(result[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i=start; i<n; i++) {
            result[index] = sortedArr[i];
            go(index+1, i, n, m);
        }
    }
}
