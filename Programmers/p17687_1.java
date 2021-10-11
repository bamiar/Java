package Programmers;

public class p17687_1 {
    public static String solution(int n, int t, int m, int p) {
        //n=진법 t=튜브가 말해야하는 숫자들 m=게임인원 p=튜브의 순서
        String answer = "";
        int number = 0;
        int index = 1;

        while(answer.length()<t) {
            String s = Integer.toString(number, n); //진법 변환
            for(int i=0; i<s.length(); i++) {
                String temp = String.valueOf(s.charAt(i));
                if (index==p) {
                    answer = answer + temp;
                }

                index = index==m? 0:index;
                ++index;
            }
            ++number;
        }
        answer = answer.toUpperCase();
        return answer.substring(0,t);
    }
}
