package LeetCode.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a collection of integers that might contain duplicates, nums, 
 * return all possible subsets.
 * 
 * Note: The solution set must not contain duplicate subsets.
 * 
 * For example:
 * 		nums = [1,2,2]
 * Solution is:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 * 
 * 
 * @author Xingwei Chen
 */
public class Subsets_II {
	/**
	 * Better solution
	 */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> each = new ArrayList<Integer>();
        helper(res, each, 0, nums);
        return res;
    }
    public void helper(List<List<Integer>> res, List<Integer> each, int pos, int[] n) {
        if (pos <= n.length) {
            res.add(each);
        }
        int i = pos;
        while (i < n.length) {
            each.add(n[i]);
            // increase the length
            helper(res, new ArrayList<>(each), i + 1, n);
            // get other probability in this length
            // 因为每个元素只添加一次, 因此可以从当前位置开始继续向后添加
            each.remove(each.size() - 1);
            i++;
            while (i < n.length && n[i] == n[i - 1]) {i++;}
        }
        return;
    }
	
	/**
	 * worse solution
	 */
    public List<List<Integer>> subsetsWithDup_my(int[] nums) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	Arrays.sort(nums);
    	
    	Queue<LinkedList<Integer>> queue = new LinkedList<LinkedList<Integer>>();
    	queue.offer(new LinkedList<Integer>());
    	int index;
    	while(!queue.isEmpty()){
    		int last = Integer.MIN_VALUE;
    		LinkedList<Integer> list = queue.poll();
    		LinkedList<Integer> temp = new LinkedList<Integer>();
    		for(int i: list){
    			temp.add(nums[i]);
    		}
    		result.add(temp);
    		try{
    			index = list.get(list.size() - 1) + 1;
    		}catch(IndexOutOfBoundsException e){
    			index = 0;
    		}
    		for(int i = index; i < nums.length && list.size() <  nums.length; i++){
    			if(nums[i] != last){
    				last = nums[i];
    				list.add(i);
    				queue.offer(new LinkedList<Integer>(list));
    				list.remove(list.size() - 1);
    			}
    		}
    	}
		return result;       
    }
    
    public static void main(String[] args){
    	int[] nums = {1,2,2};
    	Subsets_II test = new Subsets_II();
    	List<List<Integer>> result = test.subsetsWithDup(nums);
    	for(List<Integer> list: result){
    		for(int num: list){
    			System.out.print(num);
    		}
    		System.out.println();
    	}
    }
}
