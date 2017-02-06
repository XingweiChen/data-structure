package LeetCode.Array;

import java.util.List;

/**
 * Given a triangle, find the minimum path sum from top to bottom. 
 * Each step you may move to adjacent numbers on the row below.
 * 
 * For example, given the following triangle
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * 
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * 
 * Note:
 * 		Bonus point if you are able to do this using only O(n) extra space, 
 * 		where n is the total number of rows in the triangle.
 * 
 * @author Xingwei Chen
 *
 */
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
    	if(triangle == null || triangle.size() == 0){
    		return 0;
    	}else if(triangle.size() == 1){
    		return triangle.get(0).get(0);
    	}else if(triangle.size() == 2){
    		return triangle.get(0).get(0) + Math.min(
    				triangle.get(1).get(0), triangle.get(1).get(1));
    	}
        for(int i = triangle.size() - 2; i>=0; i--){
        	List<Integer> base = triangle.get(i + 1);
        	List<Integer> data = triangle.get(i);
        	for(int j = 0; j < data.size(); j++){
        		data.set(j, Math.min(base.get(j), base.get(j+1)) + data.get(j));
        	}
        }
		return triangle.get(0).get(0);
    }
}

/**

public int minimumTotal(List<List<Integer>> triangle) {
ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
ArrayList<Integer> cur = new ArrayList<Integer>();
for(Integer num: triangle.get(triangle.size() -1)){
	cur.add(num);
}
result.add(cur);
for(int i = triangle.size() - 2; i>=0; i++){
	cur.clear();
	ArrayList<Integer> base = result.get(result.size() - 1);
	List<Integer> data = triangle.get(i);
	for(int j = 0; j < base.size(); j++){
		cur.add(Math.min(base.get(i), base.get(i+1)) + data.get(i));
	}
	result.add(cur);
}
return result.get(result.size() - 1).get(0);
}
*/