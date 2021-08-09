package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baekjoon3085 { //bf
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int n = Integer.parseInt(br.readLine());
        String[][] arr = new String[n][n];
        int result = 1;

        for (int i =0; i<n; i++) {
            arr[i] = br.readLine().split("");
        }

        for (int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                String temp = arr[i][j];
                //비교1 상하
                if(i+1<n){
                arr[i][j] = arr[i+1][j];
                arr[i+1][j] = temp;
                    if (result < check(arr, n)) {
                        result = check(arr, n);
                    }

                //원상복구
                arr[i+1][j] = arr[i][j];
                arr[i][j] = temp;
                }

                //비교2
                if(j+1<n) {
                arr[i][j] = arr[i][j+1];
                arr[i][j+1] = temp;
                    if (result < check(arr, n)) {
                        result = check(arr, n);
                    }

                //원상복구
                arr[i][j+1] = arr[i][j];
                arr[i][j] = temp;
                }
            }
        }

        System.out.println(result);

    }

    static int check(String[][] arr, int n) {
        int checker = 1;

        for(int i=0; i<n; i++) {
            int count = 1;
            for(int j=1; j<n; j++) {
                if(arr[i][j].equals(arr[i][j-1])) {
                    count++;
                } else count=1;
                checker = Math.max(checker, count);
                }
            }

        for(int i=0; i<n; i++) {
            int count = 1;
            for(int j=1; j<n; j++) {
                if(arr[j][i].equals(arr[j-1][i])) {
                    count++;
                } else count=1;
                checker = Math.max(checker, count);
            }
        }

        return checker;
    }
}
