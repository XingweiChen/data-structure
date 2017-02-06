package LeetCode.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
 * Find all unique triplets in the array which gives the sum of zero.
 * 
 * Note: The solution set must not contain duplicate triplets.
 * 
 * For example, given array S = [-1, 0, 1, 2, -1, -4],
 *
 * A solution set is:
 *		[
 *		  [-1, 0, 1],
 *		  [-1, -1, 2]
 *		]
 * @author Xingwei Chen
 */
public class Three_Sum {
    public List<List<Integer>> threeSum(int[] nums) {
    	Arrays.sort(nums);
    	List<List<Integer>> result = new ArrayList<List<Integer>>(); 
    	//遍历前length - 2个数, 对每个数都进行测试
        for (int i = 0; i < nums.length-2; i++) {
        	// 如果测试过了-1, 而后面继续出现-1则将其skip
            if (i == 0 || (i > 0 && nums[i] != nums[i-1])) {
            	// 为了避免重复从当前节点的左侧 和 末尾开始, 设定sum为所需的相加等于0的target number
                int low = i+1, high = nums.length-1, sum = 0 - nums[i];
                while (low < high) {
                    if (nums[low] + nums[high] == sum) {
                        result.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        // 如果跳过同样的数
                        while (low < high && nums[low] == nums[low+1]) 
                        	low++;
                        while (low < high && nums[high] == nums[high-1]) 
                        	high--;
                        // 移动low和high指向下一个不同的数
                        low++; 
                        high--;
                    } else if (nums[low] + nums[high] < sum) // 如果相加的和小于sum则增大low
                    	low++;
                    else // 如果相加的和大于sum则缩小high
                    	high--;
               }
            }
        }
		return result;
    }
    
    public static void main(String args[]){
    	int[] nums = {-1,0,1,2,-1,-4};
    	Three_Sum test = new Three_Sum();
    	List<List<Integer>> result = test.threeSum(nums);
    	for(List<Integer> list: result){
    		for(int num: list){
    			System.out.print(num + " ");
    		}
    		System.out.println();
    	}
    }
}
