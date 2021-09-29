package Programmers;

public class p86491 {
    public static int solution(int[][] sizes) {
        int maxW = -1;
        int maxH = -1;

        for(int i=0; i< sizes.length; i++) {
            int w = Math.max(sizes[i][0], sizes[i][1]);
            int h = Math.min(sizes[i][0], sizes[i][1]);

            maxW = Math.max(maxW, w);
            maxH = Math.max(maxH, h);
        }

        return maxH * maxW;
    }
}
