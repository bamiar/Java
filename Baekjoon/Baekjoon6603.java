package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baekjoon6603 {
    private final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    static int n;
    static int[] a;
    static boolean[] check;

    public static void main(String[] args) throws Exception{
        do{
            String s = br.readLine(); //Stringtokenizer면 좋겠는데 바꾸기 귀찮다
            if(s.equals("0")) {break;}
            String[] in = s.split(" ");
            n = Integer.parseInt(in[0]);
            a = new int[n];
            check = new boolean[n];

            for(int i=1; i<=n; i++) {
                a[i-1] = Integer.parseInt(in[i]);
            }

            dfs(0,0);
            sb.append("\n");

        } while(a.length!=1);

        System.out.println(sb);
    }

    static void dfs(int line, int index) {
        // 종료조건 : index가 6개가 되면 해당 조합을 sb.append 해주고 return
        if(index==6) {
            for(int i=0; i<n; i++) {
                if(check[i]) {
                    sb.append(a[i] + " ");
                }
            }
            sb.append("\n");
        }

        for(int i=line; i<n; i++) {
            check[i] = true;
            dfs(i+1, index+1);
            check[i] = false;
        }
    }
}
