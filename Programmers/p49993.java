package Programmers;

public class p49993 {
    int solution(String skill, String[] skill_trees) {
        int answer = 0;
        int index = 0;

        for(String st : skill_trees) {
            for(int i=0; i< st.length(); i++) {
                String temp = String.valueOf(st.charAt(i));
                if(skill.contains(temp)) {
                    boolean check = temp.equals(String.valueOf(skill.charAt(index)));

                    if(check) {
                        ++index;

                    } else break;
                }

                if(i==st.length()-1) {
                    ++answer;
                }
            }
            index = 0;
        }
        return answer;
    }
}
