package LeetCode.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Given numRows, generate the first numRows of Pascal's triangle.
 * For example, 
 * 		given numRows = 5
 * 		Return
 *			[
 *			     [1],
 *			    [1,1],
 *			   [1,2,1],
 *			  [1,3,3,1],
 *			 [1,4,6,4,1]
 * 			]
 *		
 * @author Xingwei Chen
 */
public class Pascal_Triangle {
    public List<List<Integer>> generate(int numRows) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	if(numRows == 0){
    		return result;
    	}
    	List<Integer> row = new ArrayList<Integer>();
    	row.add(1);
    	result.add(new ArrayList<Integer>(row));
    	row.clear();
    	if(numRows == 1){
    		return result;
    	}
    	row.add(1);
    	row.add(1);
    	result.add(new ArrayList<Integer>(row));
    	row.clear();
    	if(numRows == 2){
    		return result;
    	}
    	
    	for(int i = 2; i < numRows; i++){
    		List<Integer> base = result.get(i - 1);
    		row.add(1);
    		for(int j = 1; j < i; j++){
    			row.add(base.get(j) + base.get(j - 1));
    		}
    		row.add(1);
    		result.add(new ArrayList<Integer>(row));
    		row.clear();
    	}
		return result;
    }
    
    public static void main(String[] args){
    	Pascal_Triangle test = new Pascal_Triangle();
    	List<List<Integer>> res = test.generate(5);
    	for(List<Integer> re: res){
    		for(int r:re){
    			System.out.print(r);
    		}
    		System.out.println();
    	}
    }
}
