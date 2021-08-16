package Programmers;

import java.util.Arrays;

public class p77485_2 {
    public static void main(String[] a) {
        solution(6,6, new int[][] {{2,2,5,4},{3,3,6,6},{5,1,6,3}});
    }

    public static int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] square = new int[rows][columns];

        //6*6 2차원배열 생성
        for(int i=0; i<rows; i++) {
            int counter = i*columns + 1;
            for(int j=0; j<columns; j++) {
                square[i][j] = counter;
                counter++;
            }
        }

        for(int i=0; i<queries.length; i++) {
            //쿼리 구역별로 2차원 배열 쪼개기
            int rowLength = queries[i][2]- queries[i][0];
            int colLength = queries[i][3] - queries[i][1];
            int[] target = new int[(queries[i][2]- queries[i][1] + queries[i][3] - queries[i][0]) * 2];

            //1차원 배열에 담기
            int idx = 0; //1차 배열에 들어갈 인덱스
            for(int j=queries[i][0]-1; j<=colLength; j++) {
                target[idx] = square[queries[i][1]-1][j];
                idx++;
            } //89

            //10 16 22
            for(int j=queries[i][1]-1; j<=rowLength; j++) {
                target[idx] = square[j][queries[i][3]-1];
                idx++;
            }

            //28, 27
            for(int j=queries[i][3]-1; j>=colLength; j--) {
                target[idx] = square[queries[i][2]-1][j];  //sqare[col][row]
                idx++;
            }

            // 26 20 14  j-> 4 3 2
            for(int j=queries[i][2]-1; j+1>=rowLength; j--) {
                target[idx] = square[j][queries[i][0]-1];
                idx++;
            }
            //1차원 배열 1회전
            //min 값 추가
            answer[i] = Arrays.stream(target).min().getAsInt();
            idx = 0;
            //회전결과 2차원배열에 대입
            for(int j=queries[i][0]-1; j<=colLength; j++) {
                if(j==queries[i][0]-1) {
                    square[queries[i][1]-1][j] = target[target.length-1];
                }
                else {
                    square[queries[i][1]-1][j] = target[idx];
                    idx++;}

            }

            for(int j=queries[i][1]-1; j<=rowLength; j++) {
                square[j][queries[i][3]-1] = target[idx] ;
                idx++;
            }

            for(int j=queries[i][3]-1; j>=colLength; j--) {
                square[queries[i][2]-1][j] = target[idx];  //sqare[col][row]
                idx++;
            }

            for(int j=queries[i][2]-1; j+1>=rowLength; j--) {
                square[j][queries[i][0]-1]=target[idx];
                idx++;
            }

            int a=answer.length;
        }

        return answer;
    }
}
