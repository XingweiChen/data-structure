package LeetCode.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of candidate numbers (C) (without duplicates) and a target number (T), 
 * find all unique combinations in C where the candidate numbers sums to T.
 * 
 * The same repeated number may be chosen from C unlimited number of times.
 * 
 * Note:
 * 		All numbers (including target) will be positive integers.
 * 		The solution set must not contain duplicate combinations.
 * 		For example, given candidate set [2, 3, 6, 7] and target 7, 
 * 		A solution set is: 
 *								[
 *								  [7],
 *								  [2, 2, 3]
 *								]
 *
 * @author Xingwei Chen
 *
 */
public class Combination_Sum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
    	if(candidates == null || candidates.length == 0){
    		return result;
    	}
		
		combination(candidates, result, new ArrayList<Integer>(), 0, target);
		return result;
    }
    
    // 由于数字是可重复使用的所以每一个sol的循环从自身开始, 这样可以重复使用自身但不会使用自身之前的数这样也避免了duplicate
    public void combination(int[] candidates, List<List<Integer>> result, List<Integer> sol, int index, int target){
    	if(target == 0){
    		result.add(new ArrayList<Integer>(sol));
    		return;
    	}
    	for(int i = index; i < candidates.length; i++){
    		if(target - candidates[i] >= 0){
    			sol.add(candidates[i]);
    			combination(candidates, result, sol, i, target - candidates[i]);
    			// remove the last number, try others possibilities
    			sol.remove(sol.size() - 1);
    		}
    	}
    }
    
    public static void main(String[] args){
    	Combination_Sum test = new Combination_Sum();
    	int[] candidates  = {2, 3, 6, 7};
    	List<List<Integer>> result = test.combinationSum(candidates, 7);
    	for(List<Integer> list : result){
    		for(int num : list){
    			System.out.print(num + " ");
    		}
    		System.out.println();
    	}
    }
}
