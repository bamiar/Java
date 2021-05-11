package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baekjoon10824 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        long result = Long.parseLong(input[0].concat(input[1]))
                + Long.parseLong(input[2].concat(input[3]));

        System.out.println(result);
    }
}
