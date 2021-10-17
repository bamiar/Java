package Programmers;

import java.util.Arrays;

public class pDMWB2110_1 { //89점
    public static String solution(String[] registered_list, String new_id) {
        String answer = "";
        boolean checker = false;
        int index=0;
        Arrays.sort(registered_list);

        while(!checker) {
            for(int i=index; i<registered_list.length; i++) {
                if (new_id.equals(registered_list[i])) {
                    new_id = makeId(new_id);
                    index=i;
                    break;
                }
                if(i== registered_list.length-1) {
                    checker=true;
                    answer = new_id;
                }
            }
        }

        return answer;
    }

    private static String makeId(String id) {
        int index = id.length();
        for(int i=0; i<id.length(); i++) {
            if(Character.isDigit(id.charAt(i))) {
                index = i;
                break;
            }
        }
        String S = id.substring(0, index);
        String N = id.substring(index, id.length());
        int n = N.length()==0?1:Integer.valueOf(N)+1;

        return S.concat(String.valueOf(n));
    }
}
