package Programmers;

import java.util.Arrays;

public class p77484 {
        public static void main(String[] args) {
            solution(new int[] {0, 0, 0, 0, 0, 0}, new int[]{31, 10, 45, 1, 6, 19});
        }

        static int[] solution(int[] lottos, int[] win_nums) {
            int[] answer = new int[2];

            Arrays.sort(lottos);
            Arrays.sort(win_nums);

            int countHit = 7;
            int countZero = 0;

            //lottos 배열과 win num 비교 (0이 아닌 것들만)
            for(int l : lottos) {
                if(l==0) {
                    countZero++;
                    continue;}
                for(int i=0; i<win_nums.length; i++) {
                    if(l==win_nums[i]) {
                        countHit--;
                        win_nums[i] = 0;
                        break;
                    }
                }
            }

            answer[1] = (countHit==7)? 6:countHit; //최저순위
            answer[0] = (countZero==6)? 1:answer[1] - countZero;//최고순위

            return answer;

    }
}
