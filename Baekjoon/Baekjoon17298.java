package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baekjoon17298 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack  = new Stack<>();

        final int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int[] a = new int[n];

        for (int i=0; i<n; i++) {
           a[i] = Integer.parseInt(st.nextToken());
        }

        for (int i=0; i<n; i++) {
            while(!stack.isEmpty() && a[stack.peek()] < a[i]) {
            a[stack.peek()] = a[i];
            stack.pop();
        }
            stack.add(i);
        }

        while(!stack.isEmpty()) {
            a[stack.pop()] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for(int output : a) {
            sb.append(output + " ");
        }

        System.out.println(sb);

    }
}
