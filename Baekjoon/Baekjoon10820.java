package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baekjoon10820 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input =  "";

        while((input=br.readLine())!=null) {
            StringBuilder sb = new StringBuilder();
            char[] chars = input.toCharArray();
            int[] counter = new int[4]; //소문자 0, 대문자 1, 숫자 2, 공백 3

            for (char i : chars) {
                if (Character.isLowerCase(i)) {
                    counter[0]++;
                } else if (Character.isUpperCase(i)) {
                    counter[1]++;
                } else if (Character.isDigit(i)) {
                    counter[2]++;
                } else if (Character.isSpaceChar(i)) {
                    counter[3]++;
                }
            }

            for (int c : counter) {
                sb.append(c + " ");
            }
            System.out.println(sb);
        }
        br.close();
    }
}
