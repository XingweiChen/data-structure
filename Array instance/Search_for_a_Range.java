package LeetCode.Array;

/**
 * Given an array of integers sorted in ascending order, find the starting and ending position 
 * of a given target value.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * If the target is not found in the array, return [-1, -1].
 * 
 * For example,
 * 		Given [5, 7, 7, 8, 8, 10] and target value 8,
 * 
 * 		return [3, 4].
 * 
 * @author Xingwei Chen
 */
public class Search_for_a_Range {
    public int[] searchRange(int[] nums, int target) {
    	int length = nums.length;
    	int[] result = {-1, -1};
    	if(nums == null || length == 0)
    		return result;
    	int i = 0, j = nums.length - 1;
        // Search for the left one
        while (i < j){
            int mid = (i + j) /2;
            if (nums[mid] < target) 
            	i = mid + 1;
            else 
            	j = mid;
        }
        if (nums[i] != target) 
        	return result;
        else 
        	result[0] = i;
        
        // Search for the right one
        j = length - 1;
        while (i < j){
        	// Make mid biased to the right
            int mid = (i + j) / 2 + 1;
            // make sure first located number for j is larger than target, 
            // which means the location is on the left of range.
            if (nums[mid] > target) 
            	j = mid - 1;  
            else 
            	i = mid;
        }
        result[1] = j;
        return result;
    }
    
    public static void main(String[] args){
    	int[] nums = {-2, -1, -1, 0, 1, 2, 3, 4, 4, 4, 4, 5, 6, 7};
    	Search_for_a_Range test = new Search_for_a_Range();
    	int[] result = test.searchRange(nums, 4);
    	for(int num: result)
    		System.out.println(num);
    }
}
