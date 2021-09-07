package Programmers;

import java.util.*;

public class p85002 {
    public static void main(String[] a) {
        solution(new int[] {60, 70, 60}, new String[] {"NNN", "NNN", "NNN"});
    }

    public static int[] solution(int[] weights, String[] head2head) {
        int n = weights.length;
        //복서 1명당 필요한 정보: 승률, 체급역전승 횟수, 몸무게, 선수번호
        int[][] players = new int[n][4]; //위 정보를 저장할 배열

        for(int i=0; i<n; i++) { //i == 선수번호
                //0: 승률구하기
            String record = head2head[i];
            int win = n - (record.replace("W", "").length());
            double lose = n - (record.replace("L", "").length()); 
            players[i][0] =  (int) ((win / (win+lose)) * 1000000); 

            //1: 체급역전승 횟수
            String[] recordArray = record.split("");
            win = 0;
            for(int j=0; j<n; j++) {
                if(recordArray[j].equals("W") && weights[i]< weights[j]) {
                    ++win;
                }
            }
            players[i][1] =  win; 

            //2: 몸무게
            players[i][2] =  weights[i]; 
            
            //3: 선수번호
            players[i][3] = i;
        }

        Arrays.sort(players, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]) {
                    if(o1[1]==o2[1]) {
                        if(o1[2]==o2[2]) {
                            if(o1[3]==o2[3]) {}
                            return o1[3] - o2[3];
                        } else return o2[2] - o1[2];
                    } else return o2[1] - o1[1];
                } else {
                    return o2[0] - o1[0];
                }
            }
        });

        int[] answer = new int[n];
        for(int i=0; i<n; i++) {
            answer[i] = players[i][3]+1;
        }

        return answer;
    }
}
