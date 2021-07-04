package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1182 {
    private final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int s;
    static int ans = 0;
    static int[] a;

    public static void main(String[] args) throws Exception{
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        a = new int[n];

        st = new StringTokenizer(br.readLine().trim());
        for(int i=0; i<n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        go(0,0 );

        System.out.println(ans);
    }

    static void go(int index, int sum) { //재귀
        if(index == n) {return;}
        if(sum + a[index] == s) {ans++;}

        go(index+1, sum);
        go(index+1, sum+a[index]);
    }
}
