package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baekjoon14500 { //bf
    public static void main(String[] args) throws Exception{
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));

        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]); //세로
        int m = Integer.parseInt(nm[1]); //가로
        Integer[][] b = new Integer[n][m];

        for(int i=0; i<n; i++) {
            String[] s = br.readLine().split(" ");
            for(int j=0; j<m; j++) {
                b[i][j] = Integer.parseInt(s[j]);
            }
        }

        int ans = -1;

        for(int i=0; i<n; i++) { //세로
            for (int j=0; j<m; j++) {  //가로
                int temp = 0;
                if (j+3<m) { //ㅡ 모양
                    temp = b[i][j] + b[i][j+1] +b[i][j+2] +b[i][j+3];
                    if (ans < temp) { ans =  temp;}
                }
                if (i+3 < n) { //ㅣ 모양
                    temp = b[i][j] + b[i+1][j] +b[i+2][j] + b[i+3][j];
                    if (ans < temp) { ans =  temp;}
                }
                if(i+1 < n && j+1 < m) { //ㅁ모양
                    temp = b[i][j] + b[i+1][j] + b[i][j+1] + b[i+1][j+1];
                    if (ans < temp) { ans =  temp;}
                }
                if(i+2<n && j+1<m) { //ㄴ 모양
                    temp = b[i][j] + b[i+1][j] + b[i+2][j] + b[i+2][j+1];
                    if (ans < temp) { ans =  temp;}
                }
                if(i+1<n && j+2<m) { //ㄴ모양 시계방향1회전
                    temp = b[i][j] + b[i+1][j] + b[i][j+1] + b[i][j+2];
                    if (ans < temp) { ans =  temp;}
                }
                if (i+2<n && j+1<m) {//ㄴ모양 시계방향2회전
                    temp = b[i][j] + b[i][j+1] + b[i+1][j+1] +b[i+2][j+1];
                    if (ans < temp) { ans =  temp;}
                }
                if (i+1<n && j+2<m) {//ㄴ모양 시계방향3회전
                    temp = b[i][j+2] + b[i+1][j] + b[i+1][j+1] + b[i+1][j+2];
                    if (ans < temp) { ans =  temp;}
                }
                if (i+2<n && j+1<m) { //ㄴ모양 좌우대칭
                    temp = b[i][j+1] + b[i+1][j+1] + b[i+2][j+1] + b[i+2][j];
                    if (ans < temp) { ans =  temp;}
                }
                if(i+1<n && j+2<m) {//ㄴ모양 시계방향1회전 상하대칭
                    temp = b[i][j] + b[i+1][j] + b[i+1][j+1] + b[i+1][j+2];
                    if (ans < temp) { ans =  temp;}
                }
                if (i+2<n && j+1<m) {//ㄴ모양 시계방향2회전 좌우대칭
                    temp = b[i][j] + b[i][j+1] + b[i+1][j] + b[i+2][j];
                    if (ans < temp) { ans =  temp;}
                }
                if (i+1<n && j+2<m) {//ㄴ모양 시계방향3회전 상하대칭
                    temp = b[i][j] + b[i][j+1] + b[i][j+2] + b[i+1][j+2];
                    if (ans < temp) { ans =  temp;}
                }
                if(i+2<n && j+1<m) {// z모양 (서있는 것 기준)
                    temp = b[i][j] + b[i+1][j] + b[i+1][j+1]  + b[i+2][j+1];
                    if (ans < temp) { ans =  temp;}
                }
                if(i+1<n && j+2<m) { // z모양 시계방향 1회전
                    temp = b[i+1][j] +b[i+1][j+1] +b[i][j+1] + b[i][j+2];
                    if (ans < temp) { ans =  temp;}
                }
                if(i+2<n && j+1<m) { // z모양 시계방향 2회전
                    temp = b[i][j+1] + b[i+1][j+1] + b[i+1][j] + b[i+2][j];
                    if (ans < temp) { ans =  temp;}
                }
                if(i+1<n && j+2<m) {// z모양 시계방향 1회전 좌우대칭
                    temp = b[i][j] + b[i][j+1] + b[i+1][j+1] + b[i+1][j+2];
                    if (ans < temp) { ans =  temp;}
                }
                if(i+1<n && j+2<m) { //T모양
                    temp = b[i][j] + b[i][j+1] + b[i][j+2] + b[i+1][j+1];
                    if (ans < temp) { ans =  temp;}
                }
                if(i+1<n && j+2<m) { //T모양 상하대칭
                    temp = b[i+1][j] + b[i+1][j+1] + b[i+1][j+2] + b[i][j+1];
                    if (ans < temp) { ans =  temp;}
                }
                if(i+2<n && j+1<m) {//T모양 시계방향 1회전
                    temp = b[i][j] + b[i+1][j] + b[i+2][j] + b[i+1][j+1];
                    if (ans < temp) { ans =  temp;}
                }
                if(i+2<n && j+1<m) {//T모양 시계방향 1회전 좌우대칭
                    temp = b[i+1][j] + b[i][j+1] + b[i+1][j+1] + b[i+2][j+1];
                    if (ans < temp) { ans =  temp;}
                }
            }
        }

        System.out.println(ans);
    }
}
