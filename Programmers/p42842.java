package Programmers;

public class p42842 {

    public static void main(String[] args) {
        solution(24, 24);
    }

    public static int[] solution(int brown, int yellow) { //카펫
        int[] answer = new int[2];

        for(int h=3; h<2000; h++) {
            for(int w=3; w<700000; w++) {
                if(2*h+2*w-4==brown && (h-2)*(w-2)==yellow) {
                    answer[0] = h;
                    answer[1] = w;
                }
                else if(2*h+2*w-4>brown) break;
            }
        }

        return answer;
    }
}
