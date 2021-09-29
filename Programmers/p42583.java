package Programmers;

import java.util.LinkedList;
import java.util.Queue;

public class p42583 {
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        class passingTruck{
            int getWeight;
            int getOut;
        }

        int answer = 0; //시간
        int truck = 0;
        int sum = 0;
        Queue<passingTruck> bridge = new LinkedList<>();

        while(truck < truck_weights.length) {
            ++answer;
            if(!bridge.isEmpty()) { //트럭 퇴장
                if (bridge.peek().getOut==answer) {
                    sum -= bridge.peek().getWeight;
                    bridge.poll();
                }
            }

            if(sum+truck_weights[truck]<=weight) { //트럭 입장
                sum += truck_weights[truck];

                passingTruck pt = new passingTruck();
                pt.getOut = answer+bridge_length;
                pt.getWeight = truck_weights[truck];
                bridge.add(pt);

                truck++;
            }
        }

        while(!bridge.isEmpty()) {
            answer = bridge.peek().getOut;
            bridge.poll();
        }

        return answer;
    }
}
