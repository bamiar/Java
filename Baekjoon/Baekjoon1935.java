package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baekjoon1935 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Double> stack = new Stack<>();

        final int n = Integer.parseInt(br.readLine());
        char[] postfix = br.readLine().toCharArray();
        double[] num = new double[n];

        for(int i=0; i<n; i++) {
            num[i] = Double.parseDouble(br.readLine());
        }

        for (int i=0; i<postfix.length; i++) {
            if(Character.isAlphabetic(postfix[i])) {
                stack.push(num[Integer.valueOf(postfix[i])-65]);
            } else {
                String p = String.valueOf(postfix[i]);
                double pop1 = stack.pop();
                double pop2 = stack.pop();
                switch (p) {
                    case "+":
                        stack.push(pop1 + pop2);
                        break;
                    case "-":
                        stack.push(pop2 - pop1);
                        break;
                    case "*":
                        stack.push(pop1 * pop2);
                        break;
                    case "/":
                        stack.push(pop2 / pop1);
                        break;
                }
            }
        }
        System.out.format("%.2f",stack.get(0));

    }
}
