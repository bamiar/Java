package Programmers;


import java.util.Arrays;

class p42748 {//k번째수

    public static void main(String[] args) {
        solution(new int[] {1, 5, 2, 6, 3, 7, 4}, new int[][] {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}});
    }

    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i=0; i<commands.length; i++) {
            int start = commands[i][0]-1;
            int end = commands[i][1]-1;
            int target = commands[i][2]-1;
            int index = 0;

            int[] temp = new int[end-start+1];

            for(int j=start; j<=end; j++) {
                temp[index] = array[j];
                index++;
            }

            Arrays.sort(temp);

            answer[i] = temp[target];
        }

        return answer;
    }

    }
