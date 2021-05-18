package Baekjoon;

import java.util.Scanner;

public class Baekjoon1212 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        String input = sc.nextLine();

        for(int i=0; i<input.length(); i++) {
            String n = Integer.toBinaryString(Integer.parseInt(String.valueOf(input.charAt(i))));
            if(n.length()==1&&i!=0) {
                n="00"+n;
            } else if(n.length()==2&&i!=0) {
                n="0"+n;
            }
            sb.append(n);
        }
        System.out.println(sb);
    }
}
