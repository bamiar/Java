package Baekjoon;

import java.util.Scanner;

public class Baekjoon2745 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.next();
        final int b = sc.nextInt();
        long result = 0;

        for(int i=0; i<n.length(); i++) {
            long p = (long) Math.pow(b,n.length()-1-i);
            if (Character.isAlphabetic(n.charAt(i))) {

                result = result + ((Integer.valueOf(n.charAt(i)))-55) * p;
            } else {
                result = result + Long.valueOf(String.valueOf(n.charAt(i)))*p;
            }
        }
        System.out.println(result);
    }
}
