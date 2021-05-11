package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baekjoon11655 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] input = br.readLine().toCharArray();

        for (int i=0; i<input.length; i++) {
            int value = Integer.valueOf(input[i]);
            if (Character.isUpperCase(input[i])) {
                if (value < 78) {
                    sb.append((char) (value + 13)); //ok
                } else {
                    sb.append((char) (value -13));
                }
            } else if(Character.isLowerCase(input[i])) {
                if (value < 110) {
                    sb.append((char) (value + 13));
                } else {
                    sb.append((char) (value -13));
                }
            }

            else {
                sb.append(input[i]);
            }
        }
        System.out.println(sb);
        br.close();
    }
}
