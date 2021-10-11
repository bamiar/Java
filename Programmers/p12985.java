package Programmers;

public class p12985 {
    int solution(int n, int a, int b) {
        int answer = 0;

        for(int i=0; i<n/2; i++) {
            ++answer;

            if(a%2==1) {++a;}
            if(b%2==1) {++b;}

            a/=2;
            b/=2;

            if(a==b) break;
        }

        return answer;
    }
}
