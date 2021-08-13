package Programmers;

import java.util.Arrays;

class p42746_1 {
    public static void main(String[] a) {
        solution(new int[] {0,0,70});
    }

    public static String solution(int[] numbers) {

        String[] nums = new String[numbers.length];
        for(int i=0; i<numbers.length; i++) {
            nums[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(nums, ((o1, o2) -> (o2+o1).compareTo(o1+o2)));

        int index = 0;
        while(index<nums.length-1) {

            for(int i=0; i<nums.length-1; i++) {
                int next1 = Integer.parseInt(nums[index].concat(nums[index+1]));
                int next2 = Integer.parseInt(nums[index+1].concat(nums[index]));
                if(next2>next1) {
                    int temp = numbers[i];
                    numbers[i] = numbers[i+1];
                    numbers[i+1] = temp;
                } else index++;
            }
        }

        StringBuilder sb = new StringBuilder();

        if(nums[0].equals("0")) {
            return "0";
        } else for(String n : nums) {
            sb.append(n);
        }

        return sb.toString();
    }


}
