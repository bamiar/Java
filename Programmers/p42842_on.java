package Programmers;

public class p42842_on {
    static int r=3; //가로
    static int l=3; //세로

    public static void main(String[] args) {
        solution(24, 24);
    }

    public static int[] solution(int brown, int yellow) { //카펫 (아직 푸는중)

        go(3, 3, brown, yellow);

        int[] answer = {r, l};
        return answer;
    }

    static void go(int x, int y, int brown, int yellow) {
        if(2*x+2*y-4==brown && (x-2)*(y-2)==yellow) {
            r = x;
            l = y;
            return;
        }
        //갈색 수 = 2x + 2y -4
        //노랑 수 = x-2 * y-2
        //brown, yellow 값이 같으면 return;

        //x+1
        go(x+1, y, brown, yellow);
        //y+1
        if(x>y) {
            go(x, y+1, brown, yellow);
        }

        return;
    }
}
