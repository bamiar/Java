package Baekjoon;

import java.util.Scanner;

public class Baekjoon10974 {
    private static final StringBuilder sb = new StringBuilder();
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++) {arr[i] = i+1;}

        for(int a : arr) {
            sb.append(a + " ");
        }
        sb.append("\n");

        while(next_permute(arr)) {
            for(int a : arr) {
                sb.append(a + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static boolean next_permute(int[] a) {
        int i = n-1;
        while (i>0 && a[i] < a[i-1] ) {
            i--;
        }
        if(i<=0) return false;

        int j = n-1;
        while(a[j] <= a[i-1]) {
            j--;
        }

        int temp = a[i-1];
        a[i-1] = a[j];
        a[j] = temp;

        j = n-1;
        while(i<j) {
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i++;
            j--;
        }
        return true;
    }
}
