package Test;

public class pPFRS3 {
    public static void main(String[] arg) {
//        solution(new int[] {7,8,10}, new int[] {10,7,8}); //100100100100
//        solution("abebeaedeac");
        solution(10);
    }

    public static int solution(int s) {
        int answer = 1000000;

        for(int i=1; i<=s; i++) {
            for(int j=1; j<=s; j++) {
                if (i*j==s) {
                    answer = Math.min((i+j)*2,answer);

                }
            }
        }

        return answer;
    }
}
