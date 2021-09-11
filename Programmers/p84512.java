package Programmers;

public class p84512 {
    public int solution(String word)
    {
        int answer = 0;
        int digit = 781;

        for(int i=0; i<word.length(); i++) {
            int num = -1;
            switch (String.valueOf(word.charAt(i))) {
                case "A" :
                    num = 0;
                    break;
                case "E" :
                    num = 1;
                    break;
                case "I" :
                    num = 2;
                    break;
                case "O" :
                    num = 3;
                    break;
                case "U" :
                    num = 4;
                    break;
            }

            answer+=(digit * num) + 1;
            digit = (digit-1)/5;
        }

        return answer;
    }
}
