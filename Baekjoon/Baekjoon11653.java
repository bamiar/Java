package Baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Baekjoon11653 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> result = new ArrayList<>();

        while (n>1) {
            for (int i=2; i<=n; i++) {
                if(n%i==0) {
                    result.add(i);
                    n = n/i;
                    break;
                }
            }
        }

        for(int i : result) {
            System.out.println(i);
        }

    }
}
