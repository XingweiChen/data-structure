package LeetCode.Array;

/**
 * Would this affect the run-time complexity? How and why?
 * Suppose an array sorted in ascending order is rotated at some pivot unknown 
 * to you beforehand. (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * Find the minimum element.
 * 
 * The array may contain duplicates.
 * 
 * @author Xingwei Chen
 *
 */
public class Find_Minimum_in_Rotated_Sorted_Array_II {
    public int findMin(int[] nums) {
    	int start = 0, end = nums.length - 1, mid;
        while(start < end){
        	mid = (start + end) / 2;
        	
        	if(nums[mid] > nums[end])
        		start = mid + 1;
        	else if(nums[mid] < nums[end])
        		end = mid;
        	else
        		end--;
        }
		return nums[start];
    }
}
