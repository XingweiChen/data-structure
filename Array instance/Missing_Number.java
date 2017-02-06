package LeetCode.Array;

/**
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, 
 * find the one that is missing from the array.
 * 
 * For example,
 * 		Given nums = [0, 1, 3] return 2.
 * Note:
 * 		Your algorithm should run in linear runtime complexity. 
 * 		Could you implement it using only constant extra space complexity?
 * 
 * @author Xingwei Chen
 *
 */
public class Missing_Number {
    public int missingNumber(int[] nums) {
		int xor = 0, i = 0;
		
		// 数组中的数为n-1个, 所以这里亦或处理到了n-1, i++之后, 变成了n
		for(i=0; i<nums.length; i++){
			// 利用 ^异或 操作来进行处理
			// 异或两次是0, 1次将该数亦或进去;
			// 
			xor = xor ^ i ^ nums[i];
		}
        return xor ^ i;
    }
}
