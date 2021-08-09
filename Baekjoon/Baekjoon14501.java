package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon14501 { //bf
    static int answer = 0;
    static int n;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        int[][] plan = new int[n+1][2];

        for(int i=1; i<=n; i++) {
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s);
            plan[i][0] = Integer.parseInt(st.nextToken());
            plan[i][1] = Integer.parseInt(st.nextToken());
        }

        go(1, plan, 0);
        System.out.println(answer);
    }

    static void go(int day, int[][] plan, int sum) {
        //day 남은 날짜

        if(day == n+1)  {
            if(sum>answer) {
                answer = sum;
            }
            return;
        }
        if(day>n+1) {return;}

            go(day+plan[day][0], plan, sum + plan[day][1]);
            go(day+1, plan, sum);
    }
}
