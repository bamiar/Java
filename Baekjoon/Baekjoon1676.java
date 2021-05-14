package Baekjoon;

import java.util.Scanner;

public class Baekjoon1676 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int input = sc.nextInt();
        int result = 0;

        for(int i=5; i<=input; i=i+5) {
            //각각의 i를 소인수분해해서 5의 개수만 구하기
            int temp = i;
            while (temp%5==0) {
                result++;
                temp = temp/5;
            }
        }
        System.out.println(result);
        sc.close();
    }
}
