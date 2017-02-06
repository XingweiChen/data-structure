package LeetCode.Array;

/**
 * Given an array with n objects colored red, white or blue, sort them so that objects 
 * of the same color are adjacent, with the colors in the order red, white and blue.
 * 
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * 
 * Note:
 * 		You are not suppose to use the library's sort function for this problem.
 * 
 * @author Xingwei Chen
 */
public class Sort_Colors {
    public void sortColors(int[] nums) {
    	int length = nums.length;
    	if(nums == null || length < 2){
    		return;
    	}
        int zero = 0, two = length - 1;
        for(int i=0; i < length; i++){
        	if(nums[i] == 0){
        		nums[i] = nums[zero];
        		nums[zero] = 0;
        		zero++;
        	}else if(nums[i] == 2 && i < two){
        		nums[i] = nums[two];
        		nums[two] = 2;
        		two--;
        		i--;
        	}
        }
    }


	public static void main(String[] args){
    	Sort_Colors test = new Sort_Colors();
    	int[] nums = {1,2,2,1,2,1,1,1,1,1,0,0,0,2,1,0};
    	test.sortColors(nums);
    	for(int num: nums)
    		System.out.println(num);
    }
}
