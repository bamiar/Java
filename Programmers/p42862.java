package Programmers;

import java.util.*;

public class p42862 {
    public static void main(String[] a) {
        solution(8, new int[] {4,5}, new int[] {5,6});
    }

    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        int[] cloth = new int[n];

        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        for(int i=0; i<lost.length; i++) {
            for(int j=0; j<reserve.length; j++) {
                if(lost[i]==reserve[j]) {
                    lost[i] = reserve[j] = -1;
                    break;
                }
            }
        }

        for(int l : lost) {
            if(l>0) {cloth[l-1]--;}
        }

        for(int r : reserve) {
            if(r>0) {cloth[r-1]++;}
        }

        for(int i=0; i<n; i++) {
            //cloth i 갯수 확인
            if (cloth[i]<0) {
                if(i-1>=0 ) {
                    if(cloth[i-1] > 0) {
                        cloth[i-1]--;
                        cloth[i]++;
                        continue;
                    }
                }
                
                if(i+1<n) {
                    if(cloth[i+1]>0) {
                        cloth[i+1]--;
                        cloth[i]++;
                    }
                }
            }
        }

        for(int c : cloth) {
            if (c<0) {
                answer--;
            }
        }

        return answer;
    }
}
