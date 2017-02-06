package LeetCode.Array;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Given an array of integers, find if the array contains any duplicates. 
 * Your function should return true if any value appears at least twice in the array, 
 * and it should return false if every element is distinct.
 * 
 * @author Xingwei Chen
 */
public class Contains_Duplicate {
    public boolean containsDuplicate(int[] nums) {
    	Set<Integer> set = new LinkedHashSet<Integer>();
    	for(int num: nums){
    		if(!set.add(num)) return true;
    	}
        return false;
    }
}
