package LeetCode.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Find all possible combinations of k numbers that add up to a number n, 
 * given that only numbers from 1 to 9 can be used and each combination should 
 * be a unique set of numbers.
 * 
 * Example 1:
 * 		Input: k = 3, n = 7
 * 		Output:	[[1,2,4]]
 * Example 2:
 * 		Input: k = 3, n = 9
 * 		Output:	[[1,2,6], [1,3,5], [2,3,4]]
 * 
 * @author Xingwei Chen
 */
public class Combination_Sum_III {
    public static List<List<Integer>> combinationSum3(int k, int n) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	combination(result, new ArrayList<Integer>(), k, n, 1);
    	return result;
    }
    
    private static void combination(List<List<Integer>> result, ArrayList<Integer> sol, int k,  int n, int start){
    	if(n == 0 && k == 0){
    		// duplicated the list sol, because list sol is a reference variable.
    		List<Integer> solution = new ArrayList<Integer>(sol);
    		result.add(solution);
    		return;
    	}else if(n < start || k == 0){ // the order of numbers is increasing.
    		return;
    	}
    	
    	for(int index = start; index <= Math.min(n, 9); index++ ){
    		// add from empty
    		sol.add(index);
    		combination(result, sol, k - 1, n - index, index + 1);
    		sol.remove(sol.size() -1); // equal to pop out the number just added.
    	}
    }
    /* Test code
    public static void main(String[] args){
    	List<List<Integer>> result = combinationSum3(3, 9);
    	for(List<Integer> sol: result){
    		for(int num: sol){
    			System.out.print(num);
    		}
    		System.out.println();
    	}
    }
    */
}
