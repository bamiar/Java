package Baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Baekjoon11005 {//진법변환
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int b = sc.nextInt();
        List<Character> result = new ArrayList();

        while (n > 0) {
            if (n % b < 10) {
                result.add((char) (n % b + '0'));
            } else result.add((char) (n % b - 10 + 'A')) //아스키코드 변환
                    ;
            n /= b;
        }
        for (int i = result.size()-1; i >= 0; i--) {
            System.out.print(result.get(i));
        }
    }
}
