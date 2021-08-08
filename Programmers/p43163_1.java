package Programmers;

import java.util.LinkedList;
import java.util.Queue;

class p43163_1 { //단어 변환 bfs

    static boolean[] visited;

    public static void main(String[]a) {
        solution("hit", "cog", new String[] {"hot", "dot", "dog", "lot", "log", "cog"});
    }

    public static int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        int answer = bfs(begin, target, words, 0);

        return answer;
    }

    static int bfs(String begin, String target, String[]words, int depth) {
        class moves {
            String changed;
            int count;
            moves(String changed, int count) {
                this.changed = changed;
                this.count = count;
            }
        }

        Queue<moves> queue = new LinkedList<>();
        queue.add(new moves(begin, depth));

        while(!queue.isEmpty()) {
            begin = queue.peek().changed;
            depth = queue.peek().count;
            queue.remove();

            if(begin.equals(target)) {
                return depth;
            }

            for(int i=0; i<words.length;i++) { //단어리스트에서 비교할 index
                if (!visited[i]) {
                    int cnt = 0;
                    for (int j = 0; j < begin.length(); j++) { //단비교할 알파벳
                        cnt = begin.charAt(j) != words[i].charAt(j) ? cnt + 1 : cnt;
                        if (cnt>1) {
                            break;
                        }
                    }
                    if (cnt==1) {
                        visited[i] = true;
                        queue.add(new moves(words[i], depth+1));
                    }
                }
            }
        }
        return 0;
    }
}