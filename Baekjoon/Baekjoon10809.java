package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baekjoon10809 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        char[] input = br.readLine().toCharArray();
        int[] alphabet = new int[26];
        int[] counter = new int[26];

        for(int i=0; i < input.length; i++) {
            int a = Integer.valueOf(input[i])-97;
            if (counter[a] < 1) {counter[a] ++;
                alphabet[a] = i+1;
            }
        }

        for (int a : alphabet) {
            sb.append(a-1 + " ");
        }

        System.out.println(sb);
    }
}
