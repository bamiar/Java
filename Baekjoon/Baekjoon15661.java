package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baekjoon15661 { //TODO
    static int[][] Team;
    static int n;
    static ArrayList<Integer> teamA = new ArrayList<>();
    static ArrayList<Integer> teamB = new ArrayList<>();
//    static Stack<Integer> teamA = new Stack<>();
//    static Stack<Integer> teamB = new Stack<>();


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        Team = new int[n][n];

        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                Team[i][j] =  Integer.parseInt(st.nextToken());
            }
        }


        int rst = go(0);

        bw.write(String.valueOf(rst));
        bw.flush();
        bw.close();
    }

    static int go(int index ) {
        if(index == n) {
            if(teamA.size()<1 || teamB.size()<1) {
                return -1;
            }
            int t1 = 0;
            int t2 = 0;

            t1 = getPoint(t1, teamA);
            t2 = getPoint(t2, teamB);

            return Math.abs(t1 - t2);
        }

        int ans = -1;

        teamA.add(index); // 자료형으로 스택을 쓰면 시간초과. Arraylist로 변경하고 성공함
        int tA = go(index+1);
        if(ans == -1 || (tA!=-1 && ans > tA)) {
            ans = tA;
        }
        teamA.remove(teamA.size()-1);

        teamB.add(index);
        int tB = go(index+1);
        if(ans == -1 || (tB!=-1 && ans > tB)) {
            ans = tB;
        }
        teamB.remove(teamB.size()-1);

        return ans;
    }

    static int getPoint(int t, ArrayList<Integer> team) {
        for(int i=0; i<team.size(); i++) {
            for(int j=0; j<team.size(); j++) {
                if(i==j) continue;
                t += Team[team.get(i)][team.get(j)];
            }
        }
        return t;
    }
}
