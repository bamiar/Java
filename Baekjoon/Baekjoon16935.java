package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon16935 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int n;
    private static int m;
    private static int r;

    public static void main(String[] args) throws Exception{
        String[] in1 = br.readLine().split(" ");
        n = Integer.parseInt(in1[0]);
        m = Integer.parseInt(in1[1]);
        r = Integer.parseInt(in1[2]);

        int[][] board = new int[n][m];
        for(int i=0; i<n; i++) {
            int[] temp = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(a ->Integer.parseInt(a)).toArray();
            board[i] = temp;
        }

        String[] cal = br.readLine().split(" ");

        for(int i=0; i<r; i++) {
            n = board.length;
            m = board[0].length;

            switch (cal[i]) {
                case "1":
                    board  = cal1(board);
                    break;
                case "2":
                    board = cal2(board);
                    break;
                case "3":
                    int[][] board3 = cal3(board);
                    board = board3;
                    break;
                case "4":
                    int[][] board4 = cal4(board);
                    board = board4;
                    break;
                case "5":
                    board = cal5(board);
                    break;
                case "6":
                    board = cal6(board);
                    break;
                default:
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<board.length;i++) {
            for(int j=0; j<board[0].length; j++) {
                sb.append(board[i][j]+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static int[][] cal1(int[][] board) {
        for (int i=0; i<n/2; i++) {
            for(int j=0; j<m; j++) {
                int temp = board[n-i-1][j];
                board[n-i-1][j] = board[i][j];
                board[i][j] = temp;
            }
        }
        return board;
    }

    static int[][] cal2(int[][] board) {
        for (int i=0; i<n; i++) {
            for(int j=0; j<m/2; j++) {
                int temp = board[i][m-j-1];
                board[i][m-j-1] = board[i][j];
                board[i][j] = temp;
            }
        }
        return board;
    }

    static int[][] cal3(int[][] board) {
        int row = board.length;
        int col = board[0].length;
        int[][] new_board = new int[col][row];


        for (int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                new_board[j][row-i-1] = board[i][j];
            }
        }
        return new_board;
    }

    static int[][] cal4(int[][] board) {
        int row = board.length;
        int col = board[0].length;
        int[][] new_board = new int[col][row];

        for (int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                new_board[col-j-1][i] = board[i][j];
            }
        }
        return new_board;
    }

    static int[][] cal5(int[][] board) {
        for(int i=0; i<n/2; i++) {
            for(int j=0; j<m/2; j++) {
                int temp1 = board[i][j+m/2];
                board[i][j+m/2] = board[i][j];

                int temp2 = board[i+n/2][j+m/2];
                board[i+n/2][j+m/2] = temp1;

                temp1 = board[i+n/2][j];
                board[i+n/2][j] = temp2;

                board[i][j] = temp1;
            }
        }
        return board;
    }

    static int[][] cal6(int[][] board) {
        for(int i=0; i<n/2; i++) {
            for(int j=0; j<m/2; j++) {
                int temp1 = board[i+n/2][j];
                board[i+n/2][j] = board[i][j];

                int temp2 = board[i+n/2][j+m/2];
                board[i+n/2][j+m/2] = temp1;

                temp1 = board[i][j+m/2];
                board[i][j+m/2] = temp2;

                board[i][j] = temp1;
            }
        }
        return board;
    }
}
