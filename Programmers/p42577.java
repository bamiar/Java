package Programmers;

import java.util.HashMap;

public class p42577 {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        HashMap<String, Integer> hashMap = new HashMap<>();

//        Arrays.sort(phone_book);

        for(int i=0; i<phone_book.length; i++) {
            hashMap.put(phone_book[i],i);
        }

        for(int i=0; i<hashMap.size(); i++) {
            for(int j = 1; j < phone_book[i].length(); j++) {
                if(hashMap.containsKey(phone_book[i].substring(0,j))) {
                    answer = false;
                    return answer;
                }
            }
        }

        return answer;
    }
}
