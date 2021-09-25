package Programmers;

import java.util.HashMap;

public class p86048 {
    public int[] solution(int[] enter, int[] leave) {
        int e = 0; //입장인덱스
        int l = 0; //퇴장인덱스
        boolean[] room = new boolean[enter.length+1]; //방에 있는 사람
        HashMap<Integer, Integer> meet= new HashMap<>(); //만난 사람 카운트

        while(e < enter.length && l<enter.length) {
            if(room[leave[l]]) {
                room[leave[l]] = false;
                l++;
            } else if(e < enter.length) {
                for(int r=1; r< room.length; r++) {
                    if(room[r]) {
                        meet.put(r, meet.get(r)+1);
                    }
                }
                meet.put(enter[e], e-l);

                room[enter[e]] = true;
                e++;
            }
        }

        int[] answer = new int[enter.length];
        for(int i=1; i<= answer.length; i++) {
            answer[i-1] = meet.get(i);
        }

        return answer;
    }
}
