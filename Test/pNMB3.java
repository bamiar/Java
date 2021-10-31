package Test;

import java.util.Deque;
import java.util.LinkedList;

public class pNMB3 {
    public static void main(String[] arg) {
        solution(1, new int[] {100,1,50,1,1});
    }

    public static int[] solution(int n, int[] coffee_times) {
        int[] answer = new int[coffee_times.length];

        class Brew {
            int order, time;
            Brew(int order, int time) {
                this.order = order;
                this.time = time;
            }
        }

        Deque<Brew> deque = new LinkedList<>();
        deque.add(new Brew(0, coffee_times[0]));
        int[] time = new int[n];

        int idx = 1;
        int fin = 0;

        while(idx!=coffee_times.length) {
            while (deque.size() <n) {
                Brew brew = new Brew(idx, coffee_times[idx]);
                deque.add(brew);
                ++idx;
            }

            while(deque.size()==n) {
                Brew brew = deque.poll();
                brew.time = brew.time-1;
                if(brew.time==0) {
                    answer[fin] = brew.order+1;
                    ++fin;
                    break;
                } else {
                    deque.addLast(brew);
                }
            }
        }

        while(!deque.isEmpty()) {
            Brew brew = deque.poll();
            brew.time = brew.time-1;
            if(brew.time==0) {
                answer[fin] = brew.order+1;
                ++fin;
            } else {
                deque.addLast(brew);
            }
        }

        return answer;
    }
}
