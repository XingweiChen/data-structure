package LeetCode.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array S of n integers, are there elements a, b, c, 
 * and d in S such that a + b + c + d = target? 
 * 
 * Find all unique quadruplets in the array which gives the sum of target.
 * 
 * Note: The solution set must not contain duplicate quadruplets.
 * 
 * For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.
 * 
 * A solution set is:
 *						[
 *						  [-1,  0, 0, 1],
 *						  [-2, -1, 1, 2],
 *						  [-2,  0, 0, 2]
 *						]
 *
 * @author Xingwei Chen
 */
public class Four_Sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	int length = nums.length;
    	if(nums == null || length < 4){
    		return result;
    	}
    	
    	Arrays.sort(nums);
    	
    	int max = nums[length - 1];
    	if(4 * nums[0] > target || 4 * max < target)
    		return result;
    	
    	int i, num4;
    	for(i = 0; i < length; i++){
    		num4 = nums[i];
    		// 同3Sum, 如果计算过-1, 第二个-1就不再计算了, 因为所有的possiblity都已经被测试
    		if(i > 0 && num4 == nums[i - 1]){
    			continue;
    		}
    		// avoid num4 to be too small   or   too large
    		if(num4 + 3 * max < target || 4 * num4 > target)
    			continue;
    		// if 4 * num4 is the solution
    		if(4 * num4 == target){
    			// if there are 4 num3 in the numbers' collection
    			if(i + 3 < length && nums[i + 3] == num4)
    				result.add(Arrays.asList(num4, num4, num4, num4));
    			break;
    		}
    		
    		threeSum(nums, target - num4, i + 1, length - 1, result, num4);
    	}
    	return result;
    }

	private void threeSum(int[] nums, int target, int start, int end, 
			List<List<Integer>> result, int num4) {
		if(start + 1 >= end)
			return;

		int max = nums[end];
		if(3 * nums[start] > target || 3 * max < target)
			return;
		
		int i, num3;
		for(i = start; i < end - 1; i++){
			num3 = nums[i];
    		// 同3Sum, 如果计算过-1, 第二个-1就不再计算了, 因为所有的possiblity都已经被测试
    		if(i > start && num3 == nums[i - 1]){
    			continue;
    		}
    		// avoid num3 to be too small   or   too large
    		if(num3 + 2 * max < target || 3 * num3 > target)
    			continue;
    		// if 4 * num4 is the solution
    		if(3 * num3 == target){
    			// if there are 4 num3 in the numbers' collection
    			if(i + 1 < end && nums[i + 2] == num3)
    				result.add(Arrays.asList(num4, num3, num3, num3));
    			break;
    		}
    		twoSum(nums, target - num3, i + 1, end, result, num4, num3);
		}
		
		
	}

	private void twoSum(int[] nums, int target, int start, int end, List<List<Integer>> result, int num4, int num3) {
		if(start >= end)
			return;
		
		if(2 * nums[start] > target || 2 * nums[end] < target)
			return;
		
		int i = start, j = end, sum, num2, num1;
		while(i < j){
			num2 = nums[i];
			num1 = nums[j];
			sum = num2 + num1;
			if(sum == target){
				result.add(Arrays.asList(num4, num3, num2, num1));
				// skip duplicate
				while( ++i < j && num2 == nums[i]);
				while( i < --j && num1 == nums[j]);
			}
			// point to next different numbers
			if(sum < target)
				i++;
			else if(sum > target)
				j--;
		}
		
		return;
	}
	
	public static void main(String[] args){
		int[] nums = {0,1,5,0,1,5,5,-4};
		Four_Sum test = new Four_Sum();
		List<List<Integer>> result = test.fourSum(nums, 11);
		for(List<Integer> list : result){
			for(int num: list){
				System.out.print(num + " ");
			}
			System.out.println();
		}
	}
}
