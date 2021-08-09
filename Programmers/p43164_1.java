package Programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class p43164_1 { //dfs
    static boolean[] used;
    static List<String> list = new ArrayList<>();

    public static void main(String[] a) {
        solution(new String[][] {{"ICN", "BOO"}, {"ICN", "COO"}, {"COO", "DOO"}, {"DOO", "COO"}, {"BOO", "DOO"}, {"DOO", "BOO"}, {"BOO", "ICN"}, {"COO", "BOO"}});
//   ANSWER: ["ICN", "BOO", "DOO", "BOO", "ICN", "COO", "DOO", "COO", "BOO"]

    }

    public static String[] solution(String[][] tickets) {
        used = new boolean[tickets.length];

        for(int i=0; i<tickets.length; i++) {
            if(tickets[i][0].equals("ICN")) {
                    used[i] = true;

                    dfs(i, 1, tickets, "ICN");
                    used[i] = false;
            }
        }

        Collections.sort(list);
        String[] answer = list.get(0).split(" ");

        return answer;
    }

    static void dfs(int ticket, int counter, String[][] tickets, String result) {
        result = result + " " + tickets[ticket][1];

        if(counter==tickets.length) {
            list.add(result);
            return;
        }

        for(int i=0; i<tickets.length; i++) {
            if(tickets[i][0].equals(tickets[ticket][1]) && !used[i]) {
                    used[i] = true;

                    dfs(i, counter+1, tickets, result);
                    used[i] = false;
            }
        }
        return;
    }
}
