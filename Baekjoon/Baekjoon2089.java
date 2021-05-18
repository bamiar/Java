package Baekjoon;

import java.util.Scanner;

public class Baekjoon2089 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String result = "";
        int n = sc.nextInt();

        if (n==0) {
            System.out.println(0);
        } else {
            while (n!=0) {
                if(n%-2 ==-1) {
                    result = ((n%-2)+2) + result;
                    n = (n/-2) + 1;
                } else {
                    result = n%-2 + result;
                    n = n/-2;
                }
            }
        }

        System.out.println(result);
    }
}
