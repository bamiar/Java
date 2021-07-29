package Programmers;

public class DfsBfsLv2 { //타겟넘버
        static int answer = 0;
        static int t;
        static int[] num;

        public int solution(int[] numbers, int target) {
            t = target;
            num = numbers;

            dfs(-1, 0);

            return answer;
        }

        private static void dfs(int index, int sum) {

            if(index>=num.length-1) {
                if(sum ==  t) {
                    answer++;
                    return;
                }
                return;
            }

            dfs(index+1, sum+num[index+1]);
            dfs(index+1, sum-num[index+1]);

            return;
    }
}
