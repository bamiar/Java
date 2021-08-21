package Programmers;

public class p81301 {
    public static void main(String[] a) {
        solution("one4seveneight");
    }

    public static int solution(String s) {
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<s.length(); i++){
            for(int k=i; k<s.length();k++) {
                if(Character.isAlphabetic(s.charAt(k))) {
                    sb.append(s.charAt(k));
                    s = s.substring(0,k) + " " + s.substring(k+1);

                    if(findNum(sb)>-1) {
                        s = s.substring(0, i) + findNum(sb) + s.substring(i+1);
                        sb.delete(0, sb.length());
                        s = s.replace(" ", "");
                        break;
                    }
                } else break;
            }
        }

        return Integer.valueOf(s);
    }

    private static int findNum(StringBuilder num) {
        switch(num.toString()) {
            case "one": return 1;
            case "two": return 2;
            case "three": return 3;
            case "four": return 4;
            case "five": return 5;
            case "six": return 6;
            case "seven": return 7;
            case "eight": return 8;
            case "nine": return 9;
            case "zero": return 0;
            default: return -1;
        }
    }
}
