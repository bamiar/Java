package Programmers;

import java.util.HashMap;

public class p77486 {
    public static void main(String[] a) {
        solution(new String[] {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"},
                new String[] {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"},
                new String[] {"young", "john", "tod", "emily", "mary"},
                new int[] {12, 4, 2, 5, 10});
    }

    public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, Integer> income = new HashMap<>();

        for(int i=0; i<enroll.length; i++) {
            map.put(enroll[i], i);
            income.put(enroll[i], 0);
        }

        for(int i=0; i<seller.length; i++) {
            int revenue = amount[i] * 100;
            String person = seller[i];

            while(revenue>=1 ) {
                int tribute = revenue/10; //round 처리할필요 없이 나눈값을 총액에서 가감하는게 낫다
                income.put(person, revenue-tribute + income.get(person));
                revenue =  tribute;
                person = referral[map.get(person)];
                if(person.equals("-")) {break;}
            }
        }

        int[] answer = new int[income.size()];

        for(int i=0; i<income.size(); i++) {
            answer[i] = income.get(enroll[i]);
        }
        return answer;
    }
}
