package LeetCode.Array;

/**
 * Given an unsorted integer array, find the first missing positive integer.
 * 
 * For example,
 * 
 * 		Given [1,2,0] return 3,
 * 		and [3,4,-1,1] return 2.
 * 
 * Your algorithm should run in O(n) time and uses constant space.
 * 
 * @author Xingwei Chen
 */
public class First_Missing_Positive {
	/*
	 * Put each number in its right place.
	 * 
	 * For example:
	 * 		When we find 5, then swap it with A[4].
	 * 
	 * At last, the first place where its number is not right, return the place + 1.
	 */
	public int firstMissingPositive(int nums[]){
		int length = nums.length, temp;
		if(nums == null || length == 0)
			return 1;
		for(int i = 0; i < length; ++ i)
			while(nums[i] > 0 && nums[i] <= length && nums[nums[i] - 1] != nums[i]){
				temp = nums[nums[i] - 1];
				nums[nums[i] - 1] = nums[i];
				nums[i] = temp;
			}
		for(int i = 0; i < length; ++ i)
			if(nums[i] != i + 1)
				return i + 1; 
		return length + 1;
	}
}
