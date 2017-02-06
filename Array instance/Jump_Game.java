package LeetCode.Array;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that position.
 * 
 * Determine if you are able to reach the last index.
 * 
 * For example:
 * 
 * 		A = [2,3,1,1,4], return true.
 * 		A = [3,2,1,0,4], return false.
 * 
 * @author Xingwei Chen
 */
public class Jump_Game {
    public boolean canJump(int[] nums) {
        int length = nums.length;
    	if(nums == null || length < 2){
        	return true;
        }
    	
        int last = length - 1;
        for(int i = length - 2; i >= 0; i--){
            if(i + nums[i] >= last) last=i;
        }
        return last <= 0;
    }
}
