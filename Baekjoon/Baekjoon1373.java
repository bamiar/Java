package Baekjoon;

import java.util.Scanner;

public class Baekjoon1373 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        String input = sc.nextLine();

        if(input.length()%3==1) {
            input="00" + input;
        }   else if(input.length()%3==2) {
            input="0" + input;
        }

        int cnt = 2;
        int sum = 0;
        for(int i=0; i<input.length(); i++) {
            sum+= Math.pow(2, cnt) * Integer.parseInt(String.valueOf(input.charAt(i)));
            cnt--;
            if (cnt==-1) {
                sb.append(sum);
                cnt = 2;
                sum = 0;
            }
        }

        System.out.println(sb);
    }
}
