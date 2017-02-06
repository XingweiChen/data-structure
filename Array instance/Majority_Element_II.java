package LeetCode.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. 
 * The algorithm should run in linear time and in O(1) space.
 * 
 * 找k个 more than ⌊  n/k ⌋  times 也是一个思想
 * 相当于每个被选中的元素都要与没有被选中的元素进行1-1消耗
 * 
 * @author Xingwei Chen
 *
 */
public class Majority_Element_II {
    public static List<Integer> majorityElement(int[] nums) {
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	if( nums != null && nums.length != 0){
    		// there are maximum 2 elements due to each of them should appear 
    		// more than ⌊ n/3 ⌋ times
    		int num1 = nums[0], num2 = nums[0], 
    				count1 = 0, count2 = 0, length = nums.length;
    		for(int i = 0; i< length; i++){
    			if(nums[i] == num1){
    				count1++;
    			}else if(nums[i] == num2){
    				count2++;
    			}else if(count1 == 0){
    				num1 = nums[i];
    				count1 = 1;
    			}else if(count2 == 0){
    				num2 = nums[i];
    				count2 = 1;
    			}else{
    				count1--;
    				count2--;
    			}
    		}
    		count1 = count2 = 0;
    		for(int num: nums){
    			if (num == num1){
    				count1++;
    			}else if(num == num2){
    				count2++;
    			}
    		}
    		
    		if(count1 > length / 3){
    			result.add(num1);
    		}
    		
    		if(count2 > length / 3){
    			result.add(num2);
    		}
    	}
		return result;  
    }
}
