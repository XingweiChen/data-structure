package LeetCode.Array;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * 
 * You may assume no duplicate exists in the array.
 * 
 * @author Xingwei Chen
 */
public class Search_in_Rotated_Sorted_Array {
	public int search(int[] nums, int target) {
        int length = nums.length;
    	if(nums == null || length == 0)
    		return -1;
        int low = 0, high = length - 1;
        // find the index of the smallest value using binary search.
        while(low < high){
            int mid = (low + high) / 2;
            if(nums[mid] > nums[high]) 
            	low = mid + 1;
            else 
            	high = mid;
        }
        // using binary search find target.
        if(low == 0 || nums[0] > target)
        	high = length - 1;
        else
        	low = 0;
        
        while(low <= high){
            int mid = (low + high) / 2;
            if(target == nums[mid])
            	return mid;
            else if(target > nums[mid])
            	low = mid + 1;
            else
            	high = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args){
    	Search_in_Rotated_Sorted_Array test = new Search_in_Rotated_Sorted_Array();
    	int[] nums = {1,3};
    	System.out.println(test.search(nums, 3));
    }
}

/** Solution_1:
 *     public int search(int[] nums, int target) {
        int length = nums.length;
    	if(nums == null || length == 0)
    		return -1;
        int low = 0, high = length - 1;
        // find the index of the smallest value using binary search.
        // Loop will terminate since mid < high, and low or high will shrink by at least 1.
        // Proof by contradiction that mid < high: if mid==high, then low==high and loop would have been terminated.
        while(low < high){
            int mid = (low + high) / 2;
            if(nums[mid] > nums[high]) 
            	low = mid + 1;
            else 
            	high = mid;
        }
        // low==high is the index of the smallest value and also the number of places rotated.
        int rot = low;
        low = 0;
        high = length - 1;
        // The usual binary search and accounting for rotation.
        while(low <= high){
            int mid = (low + high) / 2;
            int realmid = (mid + rot) % length;
            if(nums[realmid] == target)
            	return realmid;
            if(nums[realmid]<target)
            	low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }
 */
