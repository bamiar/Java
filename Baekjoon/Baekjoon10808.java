package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baekjoon10808 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        char[] input = br.readLine().toCharArray();
        int[] alphabet = new int[26];

        for(int i=0; i < input.length; i++) {
            int a = Integer.valueOf(input[i])-97;
            alphabet[a]++;
        }

        for (int a : alphabet) {
            sb.append(a + " ");
        }

        System.out.println(sb);
    }
}
