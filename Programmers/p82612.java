package Programmers;

public class p82612 {
    public static void main(String[] args) {
        solution(3, 20, 4);
    }

    public static long solution(int price, int money, int count) {
        long answer = -1;

        long cost = go(count, 0, price);
        answer = money>=cost? 0: Math.abs(cost - money);

        return answer;
    }

        static long go(int n, long sum, int price) {
        if(n>0) {
            sum = go(n-1, sum + n*price, price);
        }
        return sum;
    }

    //재귀 안쓰고도 풀 수 있음
//    long solution(int price, int money, int count) {
//        long answer = 0;
//
//        while(count>0) {
//            answer += count*price;
//            --count;
//        }
//
//        answer = money>answer?0:answer-money;
//
//        return answer;
//    }
}
