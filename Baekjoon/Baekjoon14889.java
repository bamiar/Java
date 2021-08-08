package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baekjoon14889 { //bf 백트래킹
    static int[][] Team = new int[20][20];
    static int n;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++) {
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s);
            for(int j=0; j<n; j++) {
                Team[i][j] =  Integer.parseInt(st.nextToken());
            }
        }

        Stack<Integer> teamA = new Stack<>();
        Stack<Integer> teamB = new Stack<>();

        System.out.println(go(0,teamA, teamB));
    }

    static int go(int index, Stack<Integer> a, Stack<Integer> b ) { //재귀
        if(index == n) {
            if(a.size()==n/2 && b.size()==n/2) {
                int t1 = 0;
                int t2 = 0;

                for(int i=0; i<n/2; i++) {
                    for(int j=0; j<n/2; j++) {
                        if(i==j) {continue;}
                        t1 += Team[a.get(i)][a.get(j)];
                        t2 += Team[b.get(i)][b.get(j)];
                    }
                }
                return Math.abs(t1 - t2);
            }
            return -1;
        }

        if(a.size() > n/2) {return -1;}
        if(b.size() > n/2) {return -1;}

        int ans = -1;

        a.push(index);
        int tA = go(index+1, a, b);
        if(ans == -1 || (tA!=-1 && ans > tA)) {
            ans = tA;
        }
        a.pop();

        b.add(index);
        int tB = go(index+1, a, b);
        if(ans == -1 || (tB!=-1 && ans > tB)) {
            ans = tB;
        }
        b.pop();

        return ans;
    }
}
