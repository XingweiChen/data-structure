package LeetCode.Array;

/**
 * Find the contiguous subarray within an array (containing at least one number) 
 * which has the largest product.
 * 
 * For example, given the array [2,3,-2,4],
 * the contiguous subarray [2,3] has the largest product = 6.
 * 
 * @author Xingwei Chen
 */
public class Maximum_Product_Subarray {
    public int maxProduct(int[] nums) {
    	int maximum = nums[0];
    	if(nums != null && nums.length != 0){
	        int maxhere, maxpre = nums[0], minhere, minpre = nums[0];
	        for(int i = 1; i < nums.length; i++){
	        	int num = nums[i];
	        	maxhere = Math.max(Math.max(maxpre * num, minpre * num), num);
	        	minhere = Math.min(Math.min(maxpre * num, minpre * num), num);
	        	maximum = Math.max(maximum, maxhere);
	        	maxpre = maxhere;
	        	minpre = minhere;
	        }
    	}
        return maximum;
    }
}
