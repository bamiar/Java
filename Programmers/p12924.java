package Programmers;

public class p12924 {
    public int solution(int n) {
        int answer = 0;
        int sum = 0;

        for(int i=1; i<=n/2+1; i++) {
            for(int j=i; j<=n/2+1; j++) {
                sum += j;

                if(sum==n) {
                    answer++;
                    break;
                }
                else if(sum>n) {
                    break;
                }
            }
            sum=0;
        }

        return answer+1;
    }
}
