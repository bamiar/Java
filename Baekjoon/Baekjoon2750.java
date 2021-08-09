package Baekjoon;

import java.io.IOException;
import java.util.Scanner;

public class Baekjoon2750 { //정렬
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        final int n = sc.nextInt();
        int[] a = new int[n];

        for (int i=0; i<n; i++) {
            a[i] = sc.nextInt();
        }

        //select Sort 선택정렬
//        for(int i=0; i<n; i++) {
//            for (int j=i+1; j<n; j++) {
//                if(a[i] > a[j]) {
//                    int temp = a[j];
//                    a[j] = a[i];
//                    a[i] = temp;
//                }
//            }
//        }

        //insertion sort 삽입정렬
        for(int i=1; i<n; i++) {
            int j=i-1;
            int target = a[i];
            while(j>=0 && target < a[j]) {
                a[j+1] = a[j];
                a[j] = target;
                j--;
            }
        }

        for(int i : a) {
            System.out.println(i);
        }
    }
}
