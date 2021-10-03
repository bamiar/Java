package Programmers;

public class p12911 {
    public int solution(int n) {
        String a2 = Integer.toBinaryString(n);

        int a2_1 = a2.replace("0", "").length();
        int b2_l = -1;

        while (a2_1!=b2_l) {
            n++;
            String b2 = Integer.toBinaryString(n);

            b2_l = b2.replace("0", "").length();
        }

        return n;
    }
}
