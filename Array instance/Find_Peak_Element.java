package LeetCode.Array;

/**
 * A peak element is an element that is greater than its neighbors.
 * Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.
 * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
 * You may imagine that num[-1] = num[n] = -∞.
 * 
 * For example
 * In array [1, 2, 3, 1]
 * 3 is a peak element and your function should return the index number 2.
 * 
 * @author Xingwei Chen
 *
 */
public class Find_Peak_Element {
	public int findPeakElement(int[] nums) {
		int start = 0, end = nums.length - 1, mid;				
		while(start < end){
			mid = (start + end) / 2;
			if(nums[mid] > nums[mid + 1]){
				end = mid;
			}else{
				start = mid + 1;
			}
		}
		return start;
	}
}
