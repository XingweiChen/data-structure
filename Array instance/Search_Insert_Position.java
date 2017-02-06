package LeetCode.Array;

/**
 * Given a sorted array and a target value, return the index if the target is found. 
 * If not, return the index where it would be if it were inserted in order.
 * 
 * You may assume no duplicates in the array.
 *
 * Here are few examples.
 *		[1,3,5,6], 5 → 2
 *		[1,3,5,6], 2 → 1
 *		[1,3,5,6], 7 → 4
 *		[1,3,5,6], 0 → 0
 *
 * @author Xingwei Chen
 */
public class Search_Insert_Position {
    public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length;
        while(low < high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] < target)
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }
    
    public static void main(String[] args){
    	Search_Insert_Position test = new Search_Insert_Position();
    	int[] nums = {1,3};
    	System.out.println(test.searchInsert(nums, 2));
    }
}
