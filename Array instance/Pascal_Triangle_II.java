package LeetCode.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an index k, return the kth row of the Pascal's triangle.
 * 
 * For example
 * 		given k = 3,
 * 		Return [1,3,3,1].

Note:
Could you optimize your algorithm to use only O(k) extra space?
 * 
 * @author Xingwei Chen
 */
public class Pascal_Triangle_II {
    public List<Integer> getRow(int rowIndex) {
    	List<Integer> list = new ArrayList<Integer>();
        if(rowIndex < 0) 
        	return list;
        
        for(int i= 0; i<rowIndex+1; i++){
        	list.add(0, 1);
        	for(int j = 1; j < list.size() - 1; j++)
        		list.set(j, list.get(j) + list.get(j + 1));
        }

        return list;
    }
    
    public static void main(String[] args){
    	Pascal_Triangle_II test = new Pascal_Triangle_II();
    	List<Integer> res = test.getRow(3);
    	for(Integer re: res){
    		System.out.print(re + " ");
    	}
    }
}
