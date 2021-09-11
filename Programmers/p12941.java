package Programmers;

import java.util.*;

public class p12941 {
    public int solution(int []A, int []B)
    {
        int answer = 0;
        int n = A.length - 1;
        Arrays.sort(A);
        Arrays.sort(B);

        for(int i=0; i<=n; i++) {
            answer+=A[i]*B[n-i];
        }

        return answer;
    }
}
