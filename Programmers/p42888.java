package Programmers;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class p42888 {
    public static void main(String[] a) {
        solution(new String[] {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"});
    }

    public static String[] solution(String[] record) {
        Queue<String[]> queue = new LinkedList<>();
        HashMap<String, String> nameMap = new HashMap<>();

        for(String r : record) {
            String[] log = r.split(" ");

            switch (log[0]) { //log[1]: uid, log2: 닉네임
                case "Enter" :
                    queue.add(new String[] {log[1], " 들어왔습니다."});
                    nameMap.put(log[1], log[2]);
                    break;
                case "Leave" :
                    queue.add(new String[] {log[1], " 나갔습니다."});
                    break;
                case "Change" :
                    nameMap.put(log[1], log[2]);
                    break;
                default: break;
            }
        }

        String[] answer = new String[queue.size()];

        int index = 0;
        while(!queue.isEmpty()) {

            answer[index] = nameMap.get(queue.peek()[0]) + "님이" + queue.peek()[1];
            queue.poll();
            index++;
        }

        return answer;
    }
}
