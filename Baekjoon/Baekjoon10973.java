package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon10973 { //bf 순열
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    static int n;

    public static void main(String[] args) throws Exception{
        n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if(prev_permut(arr)) {
            for(int i=0; i<n; i++) {
                sb.append(arr[i] + " ");
            }
            System.out.println(sb);
        } else {
            System.out.println(-1);
        }
    }

    static boolean prev_permut(int[] arr) {
        int i=n-1; //1. 첫 순열이 시작되는 인덱스 찾기
        while(i>0 && arr[i-1] < arr[i]) {
            i--;
        }
        if(i<=0) return false;

        int j = n-1; //2. 이전 순열 끝나는 값 찾기(위 인덱스와 스왑용)
        while(arr[j] >= arr[i-1]) {
            j--;
        }

        int temp = arr[i-1]; //3. 1, 2 swap
        arr[i-1] = arr[j];
        arr[j] = temp;

        j = n-1; //4. 마지막 순열(스왑한 값 뒷부분) 오름차순으로 정리
        while(i<j) {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        return true;
    }
}
