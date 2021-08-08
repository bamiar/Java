package Programmers;

public class p43162_1 { //dfs, 연결요소
    static boolean[] visit;
    static int answer;
    static int[][] cpu;

    public static void main(String[] args) {
        solution(3, new int[][] {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}});
    }
    public static int solution(int n, int[][] computers) {
        visit = new boolean[n];
        answer = 0;
        cpu = computers;

        for(int i=0; i<computers.length; i++) {
            if(visit[i]) continue;

            dfs(i);
            answer++;
        }

        return answer;
    }

    static void dfs(int index) {
        //방문여부 체크
        if(visit[index]) {return;}

        visit[index] = true;
        for(int i=0; i<cpu.length; i++) {
            if(index==i) continue;

            if(cpu[index][i]==1) {
                if(!visit[i]) {
                    dfs(i);
                }
            }
        }

    }
}
