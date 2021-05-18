package Baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class Baekjoon11576 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(); //미래세계 진법
        int b = sc.nextInt(); //내가 쓰는 진법

        int m = sc.nextInt(); //입력받은 미래 ㅇ0ㅇ숫자의 자릿수
        String[] n = new String[m];

        for (int i=0; i< m; i++) {
            n[i] = sc.next();
        }

        int demical = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i=0; i<m; i++) {
            //입력받은 수를 10진법으로 변환
            int aPow = (int) Math.pow(a, n.length-1-i);
            if(Character.isAlphabetic(n[i].charAt(0))) {
                demical = demical + (n[i].charAt(0) -55) * aPow;
            } else {
                demical = demical + (Integer.parseInt(n[i])) * aPow;
            }
        }

        //10진법 -> b진법
        while (demical>0) {
            int i=0;
            stack.push(demical%b);
            demical = demical/b;
            i++;
        }

        System.out.print(stack.pop());
        while(!stack.isEmpty()) {
            System.out.print(" " + stack.pop());
        }
    }
}
