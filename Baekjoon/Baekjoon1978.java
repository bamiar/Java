package Baekjoon;

import java.util.Scanner;

public class Baekjoon1978 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int counter = 0;

        while(n-- >0) {
            int input = sc.nextInt();
            if(prime(input)) {
                counter++;
            }
        }
        System.out.println(counter);
    }

    private static boolean prime(int p) {
        if (p==1) {
            return false;
        }
        for (int i = 2; i*i<=p; i++) {
            if (p%i==0) {
                return false;
            }
        }
        return true;
    }

}
