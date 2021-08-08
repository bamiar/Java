package Programmers;

public class p42839_1 {

    static boolean[] e = new boolean[10000000];
    static boolean[] visit;
    static boolean[] answered = new boolean[10000000];
    static String[] num;
    static int answer=0;

    public static void main(String[] args) {
        solution("011");
    }

    static int solution(String numbers) {
        //체, 방문배열, 문자배열 생성
        for(int i=2; i<=Math.sqrt(9999999); i++) {
            if (e[i]) {
                continue;
            }
            for (int j = i + i; j <= 9999999; j += i) {
                e[j] = true;
            }
        }

        num = numbers.split("");
        visit = new boolean[num.length];

        for (int i = 0; i < num.length; i++) {
            go(i, Integer.parseInt(num[i]), 1);
        }

        return answer;
    }

    static void go(int index, int n, int size) {
        //입력받은 n이 소수인지 확인해서 count++
        //소수체크할때 1은 빼야되고 한번 체크한 소수 두번 걸리지 않게 해야함ㅠ
        if (n>1 && !e[n] && !answered[n]) {
            answered[n] = true;
            answer++;
        }

        //배열에서 visit이 false 인 숫자로 go
        for(int i=0; i<num.length; i++) {
            visit[index] = true;
            if (i==index) {continue;}

            if (!visit[i]) {
                go(i, Integer.parseInt(n + num[i]), ++size);
                visit[i]=false;
            }
            visit[index] = false;
        }
    }
}
