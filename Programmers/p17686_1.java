package Programmers;

import java.util.Arrays;
import java.util.Comparator;

public class p17686_1 {
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        String[][] split= new String[files.length][3];

        for(int i=0; i< files.length; i++) {
            int hIndex = 0;
            while(!Character.isDigit(files[i].charAt(hIndex))) {
                ++hIndex;
            }

            String head = files[i].substring(0, hIndex);
            int nIndex = hIndex;

            while(nIndex<hIndex+6 && nIndex<files[i].length() && Character.isDigit(files[i].charAt(nIndex))) {
                ++nIndex;
            }

            String number = files[i].substring(hIndex, nIndex);
            String tail = files[i].substring(nIndex);

            split[i][0] = head;
            split[i][1] = number;
            split[i][2] = tail;
        }

        Arrays.sort(split, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return o1[0].toLowerCase().compareTo(o2[0].toLowerCase());
            }
        });

        Arrays.sort(split, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                int headCheck = o1[0].toLowerCase().compareTo(o2[0].toLowerCase());

                if(headCheck == 0 ) {
                    int num1 = Integer.parseInt(o1[1]);
                    int num2 = Integer.parseInt(o2[1]);

                    return num1 - num2;
                } else
                    return headCheck;
            }
        });

        for(int i=0; i< answer.length; i++) {
            if(split[i][2]==null) {
                answer[i] = split[i][0].concat(split[i][1]);
            } else
                answer[i] = split[i][0].concat(split[i][1].concat(split[i][2]));
        }

        return answer;
    }
}
