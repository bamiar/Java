package Programmers;

public class p12953 {
    public static void main(String[] a) {
        solution(new int[] {2,6,8,14});
    }

    public static int solution(int[] arr) {
        int answer = arr[0];

        for(int i=1; i<arr.length; i++) {
            if (i==1) {
                int min = gcd(arr[i-1], arr[i]);
                answer = (arr[i-1] * arr[i]) / min;
                continue;
            }

            int min = gcd(answer, arr[i]);
            answer = (arr[i] * answer) / min;
        }

        return answer;
    }

    static int gcd(int a, int b) {
        if(b==0) {
            return a;
        } else {
            return gcd(b, a%b);
        }
    }
}
