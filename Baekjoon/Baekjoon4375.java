package Baekjoon;

import java.util.Scanner;

public class Baekjoon4375 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int n = sc.nextInt();
            int cnt = 1;

            int x = 1 % n;; //나머지

            while(x!=0) {
                x = ((x * 10) +1)% n;
                cnt ++;
            }
            System.out.println(cnt);
            cnt = 1;
        }
    }
}