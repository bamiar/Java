package Test;

public class cKKOM2 {
    public static void main(String[] arg) {
        solution(new int[] {0,0,0,0,2,3,3}, new int[] {2,5,6}); //100100100100
    }

    public static int solution(int[] T, int[] A) {
        int ans = 0;
        boolean[] learn = new boolean[T.length];

        for(int i=0; i<A.length; i++) {
            int skill = A[i];

            while(!learn[skill]) {
                learn[skill] = true;
                skill = T[skill];
                ++ans;
            }
        }

        return ans;
    }
}
