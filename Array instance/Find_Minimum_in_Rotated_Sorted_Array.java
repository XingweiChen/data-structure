package LeetCode.Array;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown 
 * to you beforehand. (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * Find the minimum element.
 * 
 * You may assume no duplicate exists in the array.
 * 
 * @author Xingwei Chen
 *
 */
public class Find_Minimum_in_Rotated_Sorted_Array {
    public int findMin(int[] nums) {
    	int start = 0, end = nums.length - 1;
        while(start < end){
        	if(nums[start] < nums[end]){
        		return start;
        	}

        	int mid = (start + end) / 2;
        	
        	if(nums[mid] > nums[end])
        		start = mid + 1;
        	else
        		end = mid;
        }
		return nums[start];
    }
}
