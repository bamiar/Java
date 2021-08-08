package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baekjoon2751 { //정렬

    private static int[] tmp = new int[1000001];

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        mergeSort(arr, 0, n-1);

        for(int i : arr) {
            bw.write(i + "\n");
        }
        bw.flush();
    }

    private static void mergeSort(int arr[], int left, int right) { //배열 분할
//        tmp = new int[arr.length]; <- 매번 선언하면 O(N)번의 호출 시마다 크기가 O(N)인 배열을 할당받게 되므로 총 O(N^2) 시간 소요

        if (left == right) return;
        int mid;
        mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid+1, right);
        merge(arr, left, right);
    }


    private static void merge(int arr[], int left, int right) {//분할된 배열 정렬
        int L, R, k, a;
        int mid = ( left + right ) / 2;
        L = left;
        R = mid + 1;
        k = left;

        while (L <= mid && R <= right)
            if(arr[L] <= arr[R]) {
                tmp[k] = arr[L]; k++; L++;
//            tmp[k++] = arr[L] <= arr[R] ? arr[L++] : arr[R++];
            } else {
                tmp[k] = arr[R]; k++; R++;
            }
            if (L>mid) {
                for (a = R; a <= right; a++)
                tmp[k++] = arr[a];
            } else {
              for (a = L; a <= mid; a++)
                tmp[k++] = arr[a];
            }

              for (a = left; a <= right; a++)
                  arr[a] = tmp[a];
    }
}
