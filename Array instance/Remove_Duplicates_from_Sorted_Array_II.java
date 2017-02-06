package LeetCode.Array;


/**
 * Follow up for "Remove Duplicates":
 * 
 * What if duplicates are allowed at most twice?
 * 
 * For example,
 * 
 * 		Given sorted array nums = [1,1,1,2,2,3],
 * 
 * Your function should return length = 5, with the first five elements of 
 * nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the 
 * new length.
 * 
 * @author Xingwei Chen
 *
 */
public class Remove_Duplicates_from_Sorted_Array_II {
    public int removeDuplicates(int[] nums) {
    	if(nums == null || nums.length == 0){
    		return 0;
    	}
    	
    	int length = 1, count = 0;
    	for(int i=1; i < nums.length; i++){
    		if(nums[i] == nums[i - 1]){
    			count++;
    		}else{
    			count = 0;
    		}
    		
    		if(count < 2){
    			nums[length] = nums[i];
    			length++;
    		}
    	} 	
		return length;
        
    }
    
    public static void main(String[] args){
    	Remove_Duplicates_from_Sorted_Array_II test = new Remove_Duplicates_from_Sorted_Array_II();
    	int[] nums = {1,1,1,2,2,3};
    	int length = test.removeDuplicates(nums);
    	System.out.println(length);
    	for(int i=0; i<length; i++){
    		System.out.print(nums[i]);
    	}
    }
}
