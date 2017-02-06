package LeetCode.Array;

/**
 * Given an array of n positive integers and a positive integer s, find the minimal length 
 * of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
 * 
 * For example, given the array [2,3,1,2,4,3] and s = 7,
 * the subarray [4,3] has the minimal length under the problem constraint.
 * 
 * @author Xingwei Chen
 *
 */
// version_1. O(n log n)
public class Minimum_Size_Subarray_Sum {
    public static int minSubArrayLen(int s, int[] nums) {
    	if(nums == null || nums.length == 0 ){
    		return 0;
    	}
    	
    	int from = 0, sum = 0, min = Integer.MAX_VALUE;
    	
    	for(int i = 0; i < nums.length; i++){
    		sum += nums[i];
    		while(sum >= s){
    			min = Math.min(min, i - from + 1);
    			sum -= nums[from++];
    		}
    	}
    	return (min == Integer.MAX_VALUE) ? 0: min;
    }
    
    public static void main(String[] args){
    	int[] a = {4,3,2,3,1,2};
    	int min = minSubArrayLen(7, a);
    	System.out.println(min);
    }
}
