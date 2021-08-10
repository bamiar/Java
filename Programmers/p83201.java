package Programmers;

import java.util.Arrays;

class p83201 {

    public static void main(String[] a) { 
        solution(new int[][] {{100,90,98,88,65},{50,45,99,85,77},{47,88,95,80,67},{61,57,100,80,65},{24,90,94,75,65}});
//        solution(new int[][] {{50,90}, {50,87}});
    }

    public static String solution(int[][] scores) {
        String answer = "";
        int n = scores.length;

        for(int i=0; i<n; i++) {
            int[] scoreList = new int[n];
            for (int j=0; j<n;j++) {
                scoreList[j] = scores[j][i];
            }
            int min = Arrays.stream(scoreList).min().getAsInt();
            int max = Arrays.stream(scoreList).max().getAsInt();

            int minCount = (int) Arrays.stream(scoreList).filter(a -> a==min).count();
            int maxCount = (int) Arrays.stream(scoreList).filter(a -> a==max).count();

            if((minCount==1 && min==scoreList[i]) ||(maxCount==1 && max==scoreList[i]) ) {
                answer = answer + grade((Arrays.stream(scoreList).sum() - scoreList[i])/(n-1));
//                scoreList[i]=0;
                continue;
            }
            answer = answer + grade(Arrays.stream(scoreList).average().getAsDouble());
        }

        return answer;
    }

    private static String grade(double avg) {
        if(avg>=90) {
            return "A";
        } else if(avg >= 80) {
            return "B";
        } else if(avg >= 70) {
            return "C";
        } else if(avg >= 50) {
            return "D";
        } else return "F";
    }

}
