package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baekjoon6064 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while(t-- >0) {
            String[] s = br.readLine().split(" ");
            Integer[] input = new Integer[4];
            for(int i=0; i<s.length; i++) {
                input[i] = Integer.parseInt(s[i]);
            }

            //Input index 0:M, 1:N, 2:x, 3:y
            int ans = input[2];
            Boolean checker = false;

            for(int i=input[2]; i<input[0]*input[1]+1; i+=input[0]){
                int temp = i % input[1];
                if(temp==0){temp = input[1];}
                ans += i;

                if(temp == input[3]) {
                    checker=true;
                    System.out.println(i);
                    break;
                }
            }

            if(!checker) {
            System.out.println(-1);
            }
        }
        br.close();
    }
}
