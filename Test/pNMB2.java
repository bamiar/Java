package Test;

public class pNMB2 {

    public static void main(String[] arg) {
        solution(new int[][] {{5,-1,4},{6,3,-1},{2,-1,1}},1,0,
                new String[] {"go","go","right","go","right","go","left","go"});
    }

    public static int solution(int[][] office ,int r, int c, String[] move) {
        int answer = 0;

        answer += office[r][c];
        office[r][c] = 0;
        int[] robo = new int[] {r, c, 4};  //방향 동1 서2 남3 북4

        for(int i=0; i< move.length; i++) {
            switch(move[i]) {
                case "go" :
                    int[] next = go(robo, office);
                    if(next[0]==robo[0] && next[1]==robo[1])  {continue;}
                    robo = next;
                    answer += office[robo[0]][robo[1]];
                    office[robo[0]][robo[1]] =0;
                    break;
                case "right" :
                    int dr = robo[2];
                    if(dr==1) {robo[2]=3;}
                    else if(dr==2) {robo[2]=4;}
                    else if(dr==3) {robo[2]=2;}
                    else if(dr==4) {robo[2]=1;}

                    break;
                case "left" :
                    int dl = robo[2];
                    if(dl==1) {robo[2] = 4;}
                    else if(dl==2){robo[2] = 3;}
                    else if(dl==3) {robo[2] = 1;}
                    else if(dl==4) {robo[2] = 2;}
                    break;
            }
        }

        return answer;
    }

    private static int[] go(int[] r, int[][] o) { //go
        int row = r[0];
        int col = r[1];
        int[] rst = new int[] {r[0],r[1],r[2]};

        if(r[2]==1 && col+1<o.length) { //동쪽 col값 +1 했는데
            if(o[row][col+1]!=-1) {
                rst[1] = col+1;
            }
            return rst;
        } else if(r[2]==2 && col-1>-1) { //서쪽으로 이동 col -1
            if(o[row][col-1]!=-1) {
                rst[1] = col-1;
            }
            return rst;
        } else if(r[2]==3 && row+1<o.length) { //남쪽으로 이동 row +1
            if(o[row+1][col]!=-1) {
                rst[0] = row+1;
            }
            return rst;
        } else if(r[2]==4 &&  row-1>-1)  { //북쪽으로 이동 row -1
            if(o[row-1][col]!=-1) {
                rst[0] = row-1;
            }
            return rst;
        }

        return rst;
    }
}
