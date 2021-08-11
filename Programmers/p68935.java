package Programmers;

class p68935 {

    public static void main(String[] a) {
        solution(45);
    }

    public static int solution(int n) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();

        while(n!=0) {
            if(sb.length()==0 && n%3==0) {
                n = n/3;
                continue;
            }
            sb.append(n%3);
            n = n/3;
        }

        String[] three = sb.toString().split("");

        for(int i=0; i<three.length; i++) {
            answer += Integer.valueOf(three[i]) * Math.pow(3,three.length-i-1);
        }

        return answer;
    }
}
