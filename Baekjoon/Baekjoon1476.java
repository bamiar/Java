package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baekjoon1476 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int e = 1;
        int s = 1;
        int m = 1;

        for(int i=1; i<7981; i++) {
            StringBuilder sb = new StringBuilder();
            e = (e==16)?1:e;
            s = (s==29)?1:s;
            m = (m==20)?1:m;
           sb.append(e+ " " + s + " " + m);
           if(input.equals(sb.toString())) {
               System.out.println(i);
               break;
           }
           e++;
           s++;
           m++;
        }

    }
}
