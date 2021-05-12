package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Baekjoon10656 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" "))
                .mapToInt(i->Integer.parseInt(i)).toArray();
        String[][] cross = new String[input[0]][input[1]];

        //크로스퍼즐판 만들기 m=열, n=행
        for (int m=0; m<input[0]; m++) {
            String[] line = br.readLine().split("");
            for (int n=0; n<input[1]; n++) {
                cross[m][n] = line[n];
            }
        }

        //망가진 힌트 찾기  좌->우 탐색, 0~2열 순




        int totalHint = 0;
        ArrayList<String> hints = new ArrayList<>();
        for (int n=0; n<input[0]; n++) {
            for (int m=0; m<input[1]; m++) {
                if (cross[n][m].equals("!")) {
                    totalHint++;
                    cross[n][m] = String.valueOf(totalHint);
                    hints.add(String.valueOf(n+1).concat(" ").concat(String.valueOf(m+1)));
                }
            }
        }

        System.out.println(totalHint);
        for (String s : hints) {
            System.out.println(s);
        }
    }
}
