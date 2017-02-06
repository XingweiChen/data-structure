package LeetCode.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of candidate numbers (C) and a target number (T), 
 * find all unique combinations in C where the candidate numbers sums to T.
 * 
 * Each number in C may only be used once in the combination.
 * 
 * Note:
 *		All numbers (including target) will be positive integers.
 *		The solution set must not contain duplicate combinations.
 *		For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8, 
 *		A solution set is: 
 *								[
 *								  [1, 7],
 *								  [1, 2, 5],
 *								  [2, 6],
 *								  [1, 1, 6]
 *								]
 * @author 陈星为
 *
 */
public class Combination_Sum_II {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
    	if(candidates == null || candidates.length == 0){
    		return result;
    	}
		Arrays.sort(candidates);
		combination(candidates, result, new ArrayList<Integer>(), 0, target);
		return result;
    }
    
    // 由于数字是不可重复使用的所以每一个sol的循环从下一个数值开始
    public void combination(int[] candidates, List<List<Integer>> result, List<Integer> sol, int index, int target){
    	if(target == 0){
    		result.add(new ArrayList<Integer>(sol));
    		return;
    	}
    	for(int i = index; i < candidates.length; i++){
    		if(target - candidates[i] >= 0){
    			// 重新回到某个索引位置, 向该索引添加数值时, 如果添加相同的数就会造成重复
    			// Example:
    			// 我们先对1进行了所有的测试得到了116 125 17三个解, 最终sol会变成[] 这时候i++变成了1, 可这个时候索引1的i还是1
    			// 如果添加会造成 125, 17的重复, 因此我们skip, 同时由于在前一个1的测试中得到了所有1的解, 因此不会有解的遗漏
    			if (i > index && candidates[i] == candidates[i-1]) 
    				continue;
    			sol.add(candidates[i]);
    			combination(candidates, result, sol, i + 1, target - candidates[i]);
    			// remove the last number, try others possibilities
    			sol.remove(sol.size() - 1);
    		}
    	}
    }
    
    public static void main(String[] args){
    	Combination_Sum_II test = new Combination_Sum_II();
    	int[] candidates  = {10, 1, 2, 7, 6, 1, 5};
    	List<List<Integer>> result = test.combinationSum2(candidates, 8);
    	for(List<Integer> list : result){
    		for(int num : list){
    			System.out.print(num + " ");
    		}
    		System.out.println();
    	}
    }
}
