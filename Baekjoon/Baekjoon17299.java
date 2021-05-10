package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Baekjoon17299 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        final int n = Integer.parseInt(br.readLine());
        int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] count = new int[1000001];
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<n; i++) {
            count[a[i]] = count[a[i]]+1;
        }

        for(int i=0; i<n; i++) {
            while(!stack.isEmpty() && count[a[i]] > count[a[stack.peek()]]) {
                a[stack.pop()] = a[i];
            }
            stack.add(i);
        }

        while(!stack.isEmpty()) {
            a[stack.pop()] = -1;
        }

        for(int i=0; i<a.length; i++) {
            sb.append(a[i] + " ");
        }

        br.close();
        System.out.println(sb);
    }

}
