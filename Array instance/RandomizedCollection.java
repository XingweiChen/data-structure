package LeetCode.Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;

/**
 * Design a data structure that supports all following operations in average O(1) time.
 * Note: Duplicate elements are allowed.
 * 		insert(val): Inserts an item val to the collection.
 * 		remove(val): Removes an item val from the collection if present.
 * 		getRandom: Returns a random element from current collection of elements. 
 * 			The probability of each element being returned is linearly related to 
 * 			the number of same value the collection contains.
 * 
 * @author Xingwei Chen
 */
public class RandomizedCollection {
	ArrayList<Integer> result;
	HashMap<Integer, LinkedHashSet<Integer>> map;
	
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        result = new ArrayList<Integer>();
        map = new HashMap<Integer, LinkedHashSet<Integer>>();
    }
    
    /** Inserts a value to the collection. Returns true if the collection 
     * did not already contain the specified element. O(1) time*/
    public boolean insert(int val) {
    	result.add(val); // O(1)
		if(map.containsKey(val)){ // O(1)
			map.get(val).add(result.size() - 1); // O(1)
			return false;
		}else{
			map.put(val, new LinkedHashSet<Integer>()); // O(1)
			map.get(val).add(result.size() - 1); // O(1)
			return true;
		}
        
    }
    
    /** Removes a value from the collection. Returns true if the collection 
     *  contained the specified element. */
    public boolean remove(int val) {
    	if (! map.containsKey(val)) // O(1)
    		return false;
        // Obtain the set of the number in the last place of the ArrayList
        int numAtLastPlace = result.get(result.size() - 1); // O(1)

        // Do not change if the remove 
        if(val != numAtLastPlace){ // O(1)
            // Get an arbitary index of the ArrayList that contains val
            int indexToReplace = map.get(val).iterator().next(); // O(1)
            // Replace val at arbitary index with the number at end of result list.
            result.set(indexToReplace, numAtLastPlace); // O(1)
            
            /** Obtain the LinkedHashSet of the numAtLastPlace and replace
             *  the old position with the new position. */
        	LinkedHashSet<Integer> replaceWith = map.get(numAtLastPlace); // O(1)
        	replaceWith.remove(result.size() - 1); // O(1)
        	replaceWith.add(indexToReplace);
        	map.get(val).remove(indexToReplace);
        }else{
        	map.get(val).remove(result.size() - 1); // O(1)
        }
        // remove (O(n)) the last element ?? O(1) ??
        result.remove(result.size() - 1);
        
        // Remove map entry if set is now empty, then return
        if(map.get(val).isEmpty()) { // O(1)
            map.remove(val); // O(1)
        }
    	return true;
    }
    
    /** Get a random element from the collection. O(1) time. */
    public int getRandom() {
		return result.get((int)(Math.random() * result.size()));
    }
}

//Test Code
/**

package LeetCode;

public class Solution {
	public static void main(String[] args){
		RandomizedCollection rc = new RandomizedCollection();
		int[] int_list = {1,2};//{1,2,3,4,5,6,7,1,2,1,2,1,2,1};
		for (int num: int_list){
			boolean flag = rc.insert(num);
			if(!flag){
				System.out.println("------"+ num +"------");
				for(int num_1:rc.map.get(num)){
					System.out.print(num_1);
				}
			System.out.println();
			System.out.println(rc.result.size());
			}
		}
		rc.remove(2);
		int count = rc.getRandom();
		System.out.println(count);
		for(int i = int_list.length - 1; i>= 0; i--){
			int num = int_list[i];
			rc.remove(num);
			System.out.println("------"+ num +"------");
			if(rc.map.containsKey(num))
				for(int num_1:rc.map.get(num)){
					System.out.print(num_1);
				}
			System.out.println();
			System.out.println(rc.result.size());
		}
		
		//boolean param_1 = obj.insert(val);
		//boolean param_2 = obj.remove(val);
	}
}


*/