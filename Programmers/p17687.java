package Programmers;

public class p17687 {
    public static String solution(int n, int t, int m, int p) {
        //2차풀이, 1차가 효율은 더 좋다
//        String answer = "";
//
//        int temp = 0;
//        while(answer.length()<=(t-1)*m +p) {
//            answer = answer.concat(Integer.toString(temp,n));
//            ++temp;
//        }
//
//        StringBuilder sb = new StringBuilder();
//        for(int i=p-1; i<=(t-1)*m+p; i+=m ) {
//            sb.append(answer.charAt(i));
//        }
//
//        answer = sb.toString().toUpperCase();
//
//        return answer;



        //1차 풀이
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
