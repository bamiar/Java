package Baekjoon;
//https://www.acmicpc.net/problem/1874

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Baekjoon1874 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        int acs = 0;
        Stack<Integer> stack =  new Stack();
        ArrayList<String> result = new ArrayList<>();

        while(n-- >0) {
            int input = Integer.parseInt(sc.nextLine());

            if(acs <  input) {
                while (acs < input) {
                    stack.push(++acs);
                    result.add("+");
                }
                stack.pop();
                result.add("-");
            } else {
                boolean checker = false;
                while (!stack.empty()) {
                    result.add("-");
                    if (stack.pop()==input) {
                        checker = true;
                        break;
                    }
                }
                if (!checker) {
                    result.clear();
                    result.add("NO");
                    break;
                }
            }
        }

        for (String r : result) {
            System.out.println(r);
        }
        sc.close();
    }
}
