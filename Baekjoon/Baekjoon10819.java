package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon10819 {
    private final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;

    public static void main(String[] args) throws Exception{
        n = Integer.parseInt(br.readLine());
        int[] a = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        for(int i=0; i<n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        a = Arrays.stream(a).sorted().toArray();
        int ans = 0;

        do {
            ans = Math.max(maxSum(a), ans);
        } while(next_permute(a));

        System.out.println(ans);
    }

    static boolean next_permute(int[] a) {
        int i = n-1;
        while (i>0 && a[i] <= a[i-1] ) {
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

    static int maxSum(int[] a) {
        int sum =0;
        for(int i=1; i<n; i++) {
            sum += Math.abs(a[i-1] - a[i]);
        }
        return sum;
    }
}
