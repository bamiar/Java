package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Baekjoon1759 { //bf

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> alphabet = new ArrayList<>();
        String s = br.readLine();
        StringTokenizer st =  new StringTokenizer(s);

        int l = Integer.parseInt(st.nextToken()); //암호 길이
        int c = Integer.parseInt(st.nextToken()); //주어지는 알파벳 개수

        s = br.readLine();
        st = new StringTokenizer(s);


        for(int i=0; i<c; i++) {
            alphabet.add(st.nextToken());
        }
        Collections.sort(alphabet);

        go(alphabet, l, 0, "");
    }

    static void go(ArrayList alpha, int l, int index, String password) {
        if(password.length()==l) {
            if(check(password)) {
                System.out.println(password);
            }
            return;
        }

            if(index >= alpha.size()) return;
            go(alpha, l, index+1, password+(alpha.get(index)));
            go(alpha, l, index+1, password);

    }

    static boolean check(String password) { //비밀번호에 모음2 자음2 포함되었는지 체크
        int ja = 0;
        int mo = 0;

        char[] pw = password.toCharArray();
        for(char p : pw) {
            if(p=='a' || p=='e' || p=='i' || p=='o' || p=='u') {
                mo++;
            } else ja++;
        }
        return ja>=2 && mo>=1;
    }
}
