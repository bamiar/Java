package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon1158  {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Integer> que = new LinkedList<>();

        final int n = Integer.parseInt(st.nextToken());
        final int k =  Integer.parseInt(st.nextToken());

        for(int i=1; i<=n; i++) {
            que.offer(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        while(que.size()!=1) {
            int p = 0;
            for(int i=1; i<k; i++) {
                p = que.poll();
                que.add(p);
            }
            sb.append(que.poll() + ", ");
        }
        sb.append(que.poll() + ">");
        System.out.println(sb);
    }
}
