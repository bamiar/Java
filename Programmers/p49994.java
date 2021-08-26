package Programmers;

public class p49994 {
    public static void main(String[] a) {
        solution("ULURRDLLU");
    }

    public static int solution(String dirs) {
        class road{ //길 확인
            boolean up, down, left, right;

            road(boolean up, boolean down, boolean left, boolean right) {
                this.up = up;
                this.down = down;
                this.left = left;
                this.right = right;
            }
        }

        String[] order = dirs.split("");
        road[][] check = new road[11][11];
        for(int i=0; i<11; i++) {
            for(int j=0; j<11; j++) {
                check[i][j] = new road(false, false, false, false);
            }
        }

        int[] start = {5,5}; //시작점은 0,0
        int answer = 0;

        for(String o : order) {
            int[] dest = move(o, start);
            //좌우인지 상하이동인지 먼저 확인
            if(dest == start) continue;
            if(o.equals("U") && !check[start[0]][start[1]].up && !check[dest[0]][dest[1]].down) {
                ++answer;
                check[start[0]][start[1]].up = true;
                check[dest[0]][dest[1]].down = true;
            } else if(o.equals("D") && !check[start[0]][start[1]].down && !check[dest[0]][dest[1]].up) {
                ++answer;
                check[start[0]][start[1]].down = true;
                check[dest[0]][dest[1]].up = true;
            } else if(o.equals("R") &&!check[start[0]][start[1]].right && !check[dest[0]][dest[1]].left) {
                ++answer;
                check[start[0]][start[1]].right = true;
                check[dest[0]][dest[1]].left = true;
            } else if(o.equals("L") &&!check[start[0]][start[1]].left && !check[dest[0]][dest[1]].right) {
                ++answer;
                check[start[0]][start[1]].left = true;
                check[dest[0]][dest[1]].right = true;
            }

            start = dest;
        }

        return answer;
    }

    private static int[] move(String d, int[] start) {
        int y = start[0];
        int x = start[1];
        int[] dest = new int[2];

        switch(d) {
            case "U":
                y++;
                break;
            case "D":
                y--;
                break;
            case "R":
                x++;
                break;
            case "L":
                x--;
                break;
            default: break;
        }

        if(y>10 || y<0 || x<0 || x>10) {
            dest = start;
            return dest;
        } else {
            dest[0] = y;
            dest[1] = x;
        }

        return dest;
    }
}
