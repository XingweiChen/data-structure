package LeetCode.Array;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index 
 * of the array.
 * 
 * Each element in the array represents your maximum jump length at that position.
 * 
 * Your goal is to reach the last index in the minimum number of jumps.
 * 
 * For example:
 * 		Given array A = [2,3,1,1,4]
 * 
 * The minimum number of jumps to reach the last index is 2. 
 * (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 *
 * Note: You can assume that you can always reach the last index.
 * 
 * @author Xingwei Chen
 */
public class Jump_Game_II {
    public int jump(int[] nums) {
    	int length = nums.length;
    	if(nums == null || length < 2)
    		return 0;
    	
    	int jump = 0, currentMax = 0, 
    			nextMax = 0, i = 0;

	   	while(currentMax - i + 1 > 0){		//nodes count of current level>0
	   		jump++;
	   		for(; i <= currentMax; i++){	//traverse current level , and update the max reach of next level
	   			nextMax = Math.max(nextMax, nums[i] + i);
	   			if(nextMax >= length - 1)
	   				return jump;   // if last element is in level+1,  then the min jump=level 
	   		}
	   		currentMax = nextMax;
	   	}
	   	return 0;
    }
    
    /**
     *  int length = nums.length, jump;
    	if(nums == null || length < 2)
    		return 0;
    	
    	int[] count = new int[length];
    	for(int i = 0; i < length; i++){
    		for(int j = nums[i]; j > 0; j--){
    			jump = count[i];
    			if(i + j >= length - 1)
    				return count[i] + 1;
    			else{
    				if(count[i + j] == 0 || count[i + j] > jump + 1)
    					count[i + j] = jump + 1;
    			}
    		}
    	}
    	return length;
    }
    
    public static void main(String[] args){
    	Jump_Game_II test = new Jump_Game_II();
    	//{2,3,1,1,4}
    	//{2,0,2,0,1}
    	int[] nums = {2,3,1,1,4};
    	System.out.println(test.jump(nums));
    }
     */
}
