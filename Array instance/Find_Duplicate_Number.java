package LeetCode.Array;

/**
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), 
 * prove that at least one duplicate number must exist. Assume that there is only one duplicate number, 
 * find the duplicate one.
 * 
 * Note:
 * 		You must not modify the array (assume the array is read only).
 * 		You must use only constant, O(1) extra space.
 * 		Your runtime complexity should be less than O(n2).
 * 		There is only one duplicate number in the array, but it could be repeated more than once.
 * 
 * @author Xingwei Chen
 */
public class Find_Duplicate_Number {
	/**
	 * Use two point p1 & p2, p2 move 2 time fast than p1, initially differ 1 position
	 * Then when p1 and p2 colliding the point is the duplicate one
	 * 
	 * 如果一个position的值指向自己, 那么如果他不是duplicate, 它就不会被到达, 这样就不会出现困在
	 * 某个点的情况
	 */
    public int findDuplicate(int[] nums) {
    	if(nums.length <= 1){
    		return -1;
    	}
    	
    	int p1 = nums[0];
    	int p2 = nums[nums[0]];
    	while(p1 != p2){
    		p1 = nums[p1];
    		p2 = nums[nums[p2]];
    	}
		return p1;
    }
}
