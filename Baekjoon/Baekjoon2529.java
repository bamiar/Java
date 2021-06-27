package Baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Baekjoon2529 {
    static boolean[] check = new boolean[10];
    static char[] arr = new char[10];
    static ArrayList<String> ans = new ArrayList<>();
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i=0; i<n; i++) {
            arr[i] = sc.next().toCharArray() [0];
        }

        go(0, "");
        Collections.sort(ans);
        int m = ans.size();
        
        System.out.println(ans.get(m-1));
        System.out.println(ans.get(0));
    }

    static void go(int index, String rst) {
        if(index == n+1) {
            if(ok(rst)) {
                ans.add(rst);
            }
            return;
        }

        for(int i=0; i<=9; i++) {
            if (check[i]) continue;
            check[i] = true;
            go(index+1, rst + i);
            check[i] = false;

        }
    }

    static boolean ok (String num) {
        for(int i=0; i<n; i++) {
            if(arr[i] == '<') {
                if(num.charAt(i) > num.charAt(i+1)) return false;
            } else if(arr[i] == '>') {
                if(num.charAt(i) < num.charAt(i+1)) return false;
            }
        }
        return true;
    }

    static boolean good(char a, char b, char abt) {
        if(abt == '>') {
            if (a<b) return false;
        }
        if(abt == '<') {
            if(a>b) return false;
        }
        return true;
    }
}
