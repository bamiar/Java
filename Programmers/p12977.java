package Programmers;

public class p12977 {
    public static int solution(int[] nums) {
        int answer = 0;

        for(int i=0; i<nums.length; i++) {
            for(int j=i+1; j<nums.length; j++) {
                for(int k=j+1; k<nums.length; k++) {
                    int sum = nums[i] + nums[j]+nums[k];
                    int index = 2;
                    boolean checker = true;

                    while(index*index<=sum) {
                        if(sum%index==0) {
                            checker = false;
                            break;
                        }
                        index++;
                    }

                    if (checker) {
                        answer+=1;
                    }
                }
            }
        }
        return answer;
    }
}
