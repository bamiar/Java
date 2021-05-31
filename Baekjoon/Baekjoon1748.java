package Baekjoon;

import java.util.Scanner;

public class Baekjoon1748 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt = String.valueOf(n).length();
        int ans = 0;
        if (cnt==1) {
            System.out.println(n);
        } else {
            for(int i=cnt; i>0; i-- ) {
                if (i==cnt) {
                    ans += (n-Math.pow(10, i-1) +1) * i;
                } else if(i==1) {
                    ans += Math.pow(10,i-1) -1;
                } else {
                    ans += (Math.pow(10,i) - Math.pow(10, i-1)) * i;
                }
            }
            System.out.println(ans+9);
        }
    }
}
