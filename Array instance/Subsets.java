package LeetCode.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of distinct integers, nums, return all possible subsets.
 * Note: The solution set must not contain duplicate subsets.
 * For example,
 * If nums = [1,2,3], a solution is:
 *
 *		[
 *		  [3],
 *		  [1],
 *		  [2],
 *		  [1,2,3],
 *		  [1,3],
 *		  [2,3],
 *		  [1,2],
 *		  []
 *		]
 * 
 * 
 * @author Xingwei Chen
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> each = new ArrayList<>();
        helper(result, each, 0, nums);
        return result;
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
        }
        return;
    }
}
