package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class Baekjoon15656 { //백트래킹
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
        go(0, n, m);

        System.out.println(sb);
//        br.close();
//        bw.close();
    }


    static void go(int index, int n, int m) {
        //index : 값을 채워넣을 result 수열 위치
        //n 자연수 개수
        //m 수열 길이
        if(index ==m) {
            //result 출력
//            try {
                for(int i=0; i<m; i++) {
//                    bw.write(result[i] + " ");
                    sb.append(result[i] + " ");
                }
//                bw.write("\n"); // 이런식으로 매번 출력해주게되면 시간초과가 난다.
//                bw.flush(); //출력문은 재귀 밖으로 뺄 것ㅠ
                sb.append("\n");
                return;
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            return;
        }

        for(int i=0; i<n; i++) {
            result[index] = sortedArr[i];
            go(index+1, n, m);
        }
    }
}