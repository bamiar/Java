package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baekjoon10971 { //bf 백트래킹
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int ans = 2147483647;

    public static void main(String[] args) throws Exception{
        n = Integer.parseInt(br.readLine());
        int[] cities = new int[n];

        for(int i=0; i<n; i++) {
            cities[i] = i;
        }

        int[][] cost = new int[n][n];
        for(int i=0; i<n; i++) {
            String[] in = br.readLine().split(" ");
            for (int j=0; j<n; j++) {
                cost[i][j] =  Integer.parseInt(in[j]);
            }
        }

        do {
            getCost(cities, cost);
        } while (next_permute(cities));

        System.out.println(ans);
    }

    static boolean next_permute(int[] arr) {
        int i = n-1;
        while(i>0 && arr[i-1] > arr[i]) {
            i--;
        }
        if(i<=0)
            return false;

        int j = n-1;
        while(arr[j] <= arr[i-1] ) {
            j--;
        }

        int temp = arr[i-1];
        arr[i-1] = arr[j];
        arr[j] = temp;

        j = n-1;
        while(j>i) {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }

        return true;
    }

    //도시간 이동비용 구하는 함수
    static void getCost(int[] arr, int[][] cost ) {
        int sum =0;
        int c = 0;

        for(int i=0; i<n; i++) {

            if (i==n-1) {
                c = cost[arr[i]][arr[0]];
            } else c = cost[arr[i]][arr[i+1]];

            if(c==0) {
                return;
            } else sum += c;
        }

        ans = Math.min(sum, ans);
    }
}
