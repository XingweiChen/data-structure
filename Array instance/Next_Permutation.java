package LeetCode.Array;

/**
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * 
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 * 
 * The replacement must be in-place, do not allocate extra memory.
 * 
 * Here are some examples. 
 * 
 * 		Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 * 
 * 				1,2,3 → 1,3,2
 * 				3,2,1 → 1,2,3
 * 				1,1,5 → 1,5,1
 * 
 * @author Xingwei Chen
 */
public class Next_Permutation {
	public void nextPermutation(int[] nums) {
	    int length = nums.length;
	    if(nums == null || length < 2)
	        return;
	    int index = length - 1;
	    
	    while(index > 0){
	        if(nums[index - 1] < nums[index])
	            break;
	        index--;
	    }
	    // if the array(nums) sorted in descending order, reverse the array.
	    if(index==0){
	        reverse(nums, 0, length-1);
	        return;
	    }else{
	        int val = nums[index-1];
	        int j = length - 1;
	        while(j >= index){
	            if(nums[j] > val)
	                break;
	            j--;
	        }
	        swap(nums, j, index-1);
	        reverse(nums, index, length-1);
	        return;
	    }
	}

	private void swap(int[] num, int i, int j){
	    int temp=0;
	    temp=num[i];
	    num[i]=num[j];
	    num[j]=temp;
	}

	private void reverse(int[] num, int start, int end){   
	    if(start>end)
	        return;
	    for(int i=start;i<=(end+start)/2;i++)
	        swap(num,i,start+end-i);
	}
}
