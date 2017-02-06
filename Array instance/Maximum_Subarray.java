package LeetCode.Array;

/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * 
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 * 		the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 * 
 * @author Xingwei Chen
 */
public class Maximum_Subarray {
    public int maxSubArray(int[] nums) {
    	int length = nums.length;
    	if(nums == null || length == 0){
    		return 0;
    	}
    	int max = nums[0];
    	for(int i = 1; i < length; i++){
    		nums[i] = Math.max(nums[i - 1] + nums[i], nums[i]);
    		max = Math.max(nums[i], max);
    	}
		return max;
    }
    
    public static void main(String[] args){
    	//{-2,1,-3,4,-1,2,1,-5,4}
    	int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
    	Maximum_Subarray test = new Maximum_Subarray();
    	System.out.println(test.maxSubArray(nums));
    }
}
