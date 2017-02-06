package LeetCode.Array;

/**
 * Rotate an array of n elements to the right by k steps.
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 * Note:
 * 		Try to come up as many solutions as you can, there are at least 3 different ways to 
 * 		solve this problem.
 * 
 * @author Xingwei Chen
 *
 */
public class Rotate_Array {
    public void rotate(int[] nums, int k) {
    	k %= nums.length;
    	//[1, 2, 3, 4, 5, 6, 7]
        reverse(nums, 0, nums.length - 1);
        //[7, 6, 5, 4, 3, 2, 1]
        reverse(nums, 0, k - 1);
        //[5, 6, 7, 4, 3, 2, 1]
        reverse(nums, k, nums.length - 1);
        //[5, 6, 7, 1, 2, 3, 4]
    }
    
    public void reverse(int[] nums, int start, int end){
    	while(start < end){
    		int temp = nums[start];
    		nums[start] = nums[end];
    		nums[end] = temp;
    		start++;
    		end--;
    	}
    }
}
