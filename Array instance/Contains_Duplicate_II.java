package LeetCode.Array;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Given an array of integers and an integer k, find out whether there are two distinct 
 * indices i and j in the array such that nums[i] = nums[j] and the absolute difference 
 * between i and j is at most k.
 * 
 * @author Xingwei Chen
 *
 */
public class Contains_Duplicate_II {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		Set<Integer> set = new LinkedHashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
        	// if i > k, remove the (i-k-1)th element which is out of range
            if(i > k) set.remove(nums[i-k-1]);
            // if can not add, then return true
            if(!set.add(nums[i])) return true; // O(1) time
        }
        return false;
    }
}
