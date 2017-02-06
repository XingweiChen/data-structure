package LeetCode.Array;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Design a data structure that supports all following operations in average O(1) time.
 * 		insert(val): Inserts an item val to the set if not already present.
 * 		remove(val): Removes an item val from the set if present.
 * 		getRandom: Returns a random element from current set of elements. 
 * 			Each element must have the same probability of being returned.
 * 
 * @author Xingwei Chen
 *
 */
public class RandomizedSet {
	ArrayList<Integer> list;
	HashMap<Integer, Integer> map;
	
    /** Initialize your data structure here. */
    public RandomizedSet() {
    	list = new ArrayList<Integer>();
    	map = new HashMap<Integer, Integer>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. O(1) time */
    public boolean insert(int val) {
    	if(map.containsKey(val)){
    		return false;
    	}else{
    		map.put(val, list.size());
	    	list.add(val);
			return true; 
		}
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. O(1) time*/
    public boolean remove(int val) {
    	if(map.containsKey(val)){
    		int index = map.get(val);
    		if(list.size() - 1 > index){
    			int last = list.get(list.size() - 1);
        		list.set(index, last);  // O(1)
        		map.put(last, index);
    		}
    		list.remove(list.size() - 1);
    		map.remove(val);
    		return true;
    	}else{
    		return false;
    	}
    }
    
    /** Get a random element from the set. O(1) time */
    public int getRandom() {
        return list.get((int) (Math.random() * list.size()));  // O(1)
    }
}
