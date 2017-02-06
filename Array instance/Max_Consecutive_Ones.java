package LeetCode.Array;

public class Max_Consecutive_Ones {
    public int findMaxConsecutiveOnes(int[] nums) {
    	int max = 0, count = 0;
        for(int num: nums){
            if(num == 0){
            	if(count > max){
            		max = count;
            	}
            	count = 0;
            }else if(num == 1){
            	count++;
            }
        }
        return max;
    }
}
