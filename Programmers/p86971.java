package Programmers;

import java.util.ArrayList;
import java.util.List;

public class p86971 {
    static boolean[] visited;
    static List<Integer>[] wire;
    static int topSum;
    
    static int solution(int n, int[][] wires) {
        int answer = 101;
        wire = new ArrayList[n+1];
        for(int i=0; i<=n; i++) {
            wire[i] = new ArrayList<>();
        }
        for(int[] w : wires) {
            wire[w[0]].add(w[1]);
            wire[w[1]].add(w[0]);
        }

        for(int i=0; i<wires.length; i++) {
            topSum = 0;
            visited = new boolean[n+1];
            int skipS = wires[i][0];
            int skipE = wires[i][1];

            dfs(n, skipS, skipE, 1);
            answer = Math.min(Math.abs(topSum-(n-topSum)), answer);
        }

        return answer;
    }

    static int dfs(int index, int skipS, int skipE, int tops) {
        visited[index] = true;
        topSum = Math.max(tops, topSum);

        for(int y : wire[index]) {
            if((index==skipS && y==skipE) || (index==skipE && y==skipS)) {
                continue;
            }
            if(!visited[y]) {
                tops = dfs(y, skipS, skipE, ++tops);
            }
        }
        return tops;
    }
}
