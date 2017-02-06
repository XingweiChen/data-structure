package LeetCode.Array;

/**
 * Given an array and a value, remove all instances of that value in place and return the new length.
 * 
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * 
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * 
 * Example:
 * 		Given input array nums = [3,2,2,3], val = 3
 * 
 * Your function should return length = 2, with the first two elements of nums being 2.
 * 
 * @author Xingwei Chen
 */
public class Remove_Element {
    public int removeElement(int[] nums, int val) {
    	int length = nums.length;
    	if(nums == null || length == 0)
    		return length;	
    	int j = 0;
    	for(int i = 0; i < length; i++){
    		if(nums[i] != val){
    			nums[j++] = nums[i];
    		}
    	}
    	if(nums[0] == val){
    		nums = null;
    		return 0;
    	}
    	return j;
    }
}
