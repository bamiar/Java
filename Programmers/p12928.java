package Programmers;

public class p12928 {
    public static int solution(int n) { //약수의 합
        int answer = 0;

        for(int i=1; i<=n/2; i++) {
            if(n%i==0) {
                answer += i;
            }
        }

        return answer + n;
    }
}
