package Test;

public class cKKOM3 {
    public static void main(String[] arg) {
        solution(new int[] {7, -5, -5, -5, 7, -1, 7}); //100100100100
    }

    public static int solution(int[] A) {
        int length = A.length;
        if(length < 2){
            return length;
        }

        int[] a = new int[] {0, A[0]};
        int[] b = new int[] {1, A[1]};
        int start = 0;
        int now = 2;
        int ans = now;

        for(int i=2; i < A.length; i++) {
            int idx = A[i];
            int checker = start%2;

            if(idx == a[1] && (i-start)%2==checker) {
                a[0] = i;
                now++;
            } else if(idx == b[1] && (i-start)%2!=checker) {
                b[0] = i;
                now++;
            } else {
                if(A[i-1] == a[1]) {
                    now = i - b[0];
                    b[0] = i;
                    b[1] = idx;
                } else {
                    now = i - a[0];
                    a[0] = i;
                    a[1] = idx;
                }
            }
            ans = Math.max(ans, now);
        }

        return ans;
    }
}
