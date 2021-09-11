package Programmers;

import java.util.Locale;

public class p12916 {

    static boolean solution(String s) {
        s = s.toLowerCase(Locale.ROOT);
        int p = s.length();

        s = s.replace("p", "");
        p = p - s.length();

        int y = s.length();
        s = s.replace("y", "");
        y = y-s.length();

        boolean answer = p==y? true:false;

        return answer;
    }
}
