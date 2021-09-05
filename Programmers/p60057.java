package Programmers;

public class p60057 {
    public static int p60057(String s) {
        int answer = 1000;

        if(s.length() ==1) {return 1;}

        for(int i=1; i<s.length()/2+1; i++) {
            int count = 1;
            int shorten = s.length();
            for(int j=0; j+i<s.length(); j+=i) {
                String prev = s.substring(j, j+i);
                int nextEnd = Math.min(j+2*i, s.length());
                String next = s.substring(j+i, nextEnd);

                if (prev.equals(next)){
                    ++count;
                    if(nextEnd+i > s.length()) {
                        shorten = (shorten - count*i) + (String.valueOf(count).length()) + i;
                        break;
                    }
                } else {
                    if(j == 0 || count==1) {continue;}
                    shorten = (shorten - count*i) + (String.valueOf(count).length()) + i;
                    count = 1;
                }
            }
            answer = Math.min(shorten, answer);
        }
        return answer;
    }
}
