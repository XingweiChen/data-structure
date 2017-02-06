package LeetCode.Array;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Given two words (beginWord and endWord), and a dictionary's word list, 
 * find all shortest transformation sequence(s) from beginWord to endWord, such that:
 * 		Only one letter can be changed at a time
 * 		Each intermediate word must exist in the word list
 * 
 * For example,
 * 		Given:
 * 			beginWord = "hit"
 * 			endWord = "cog"
 * 			wordList = ["hot","dot","dog","lot","log"]
 * Return
 * 		[
 * 			["hit","hot","dot","dog","cog"],
 * 			["hit","hot","lot","log","cog"]
 * 		]
 * 
 * @author Xingwei Chen
 */
public class Word_Ladder_II {
	List<List<String>> results;
	List<String> list;
	Map<String,List<String>> map;
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        results= new ArrayList<List<String>>();
        if (dict.size() == 0)
			return results;
        
        int curr=1,next=0;	        
        boolean found=false;	        
        list = new LinkedList<String>();	       
		map = new HashMap<String,List<String>>();
		
		Queue<String> queue= new ArrayDeque<String>();
		Set<String> unvisited = new HashSet<String>(dict);
		Set<String> visited = new HashSet<String>();
		
		queue.add(start);			
		unvisited.add(end);
		unvisited.remove(start);
		//BFS
		while (!queue.isEmpty()) {
		   
			String word = queue.poll();
			curr--;				
			for (int i = 0; i < word.length(); i++){
			   StringBuilder builder = new StringBuilder(word); 
				for (char ch='a';  ch <= 'z'; ch++){
					builder.setCharAt(i,ch);
					String new_word=builder.toString();	
					if (unvisited.contains(new_word)){
						//Handle queue
						if (visited.add(new_word)){//Key statement,Avoid Duplicate queue insertion
							next++;
							queue.add(new_word);
						}
						
						if (map.containsKey(new_word))//Build Adjacent Graph
							map.get(new_word).add(word);
						else{
							List<String> l= new LinkedList<String>();
							l.add(word);
							map.put(new_word, l);
						}
						
						if (new_word.equals(end)&&!found) found=true;		
													
					}

				}//End:Iteration from 'a' to 'z'
			}//End:Iteration from the first to the last
			if (curr==0){
				if (found) break;
				curr=next;
				next=0;
				unvisited.removeAll(visited);
				visited.clear();
			}
		}//End While

		backTrace(end,start);
		
		return results;        
    }
    private void backTrace(String word,String start){
    	if (word.equals(start)){
    		list.add(0,start);
    		results.add(new ArrayList<String>(list));
    		list.remove(0);
    		return;
    	}
    	list.add(0,word);
    	if (map.get(word)!=null)
    		for (String s:map.get(word))
    			backTrace(s,start);
    	list.remove(0);
    }
	/**
	 * test code
	 */
    public static void main(String[] args){
    	Word_Ladder_II wl = new Word_Ladder_II();
    	String[] word_list = {"hit","cog","hot","dot","dog","lot","log"};
    	Set<String> wordList = new LinkedHashSet<String>();
    	for(String word: word_list){
    		wordList.add(word);
    	}
    	List<List<String>> result = wl.findLadders("hit","cog", wordList);
    	for(List<String> list: result){
    		for(String s: list){
    			System.out.print(s);
    		}
    		System.out.println();
    	}
    }
}


/**
 * Version_1
public static List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
	List<List<String>> result = new ArrayList<List<String>>();
	if(beginWord.length() != endWord.length() || !wordList.contains(beginWord)
			|| !wordList.contains(endWord)){
		return result;
	}
	
	if(beginWord.equals(endWord)){
		ArrayList<String> sol = new ArrayList<String>();
		sol.add(beginWord);
		result.add(sol);
		return result;
	}
	
	HashMap<String, ArrayList<String>> slot_dict = new HashMap<String, ArrayList<String>>();
    HashMap<String, ArrayList<String>> closest_word = new HashMap<String, ArrayList<String>>();
	
	for(String word: wordList){
        for(int i=0; i<word.length(); i++){
        	String key = word.substring(0, i) + " " + word.substring(i+1);
        	if(!slot_dict.containsKey(key))
        		slot_dict.put(key, new ArrayList<String>());
        	slot_dict.get(key).add(word);
        }
    }
	
	for(String slot: slot_dict.keySet()){
		ArrayList<String> word_list = slot_dict.get(slot);
		for(int i=0; i < word_list.size(); i++){
			for(int j=i+1; j < word_list.size(); j++){
				String word_1 = word_list.get(i);
				String word_2 = word_list.get(j);
				if(!closest_word.containsKey(word_1))
					closest_word.put(word_1, new ArrayList<String>());
				closest_word.get(word_1).add(word_2);
				if(!closest_word.containsKey(word_2))
					closest_word.put(word_2, new ArrayList<String>());
				closest_word.get(word_2).add(word_1);
			}
		}
	}
	
	if(closest_word.isEmpty()){
		return result;
	}
	
	LinkedList<ArrayList<String>> ll = new LinkedList<ArrayList<String>>();
	ArrayList<String> sol = new ArrayList<String>();
	sol.add(beginWord);
	ll.offer(sol);
	while(!ll.isEmpty()){
		ArrayList<String> word_sequence = ll.pop();
		String last_word = word_sequence.get(word_sequence.size() - 1);
		if(!closest_word.containsKey(last_word)){
			continue;
		}
		for(String word: closest_word.get(last_word)){
			if(word.equals(endWord)){
				if(result.isEmpty() || result.get(0).size() > word_sequence.size()){
					ArrayList<String> solution = new ArrayList<String>(word_sequence);
					solution.add(word);
					result.add(solution);
				}
			}	
			if((result.isEmpty() || result.get(0).size() > word_sequence.size() + 1)
					&& !word_sequence.contains(word)){
				ArrayList<String> solution = new ArrayList<String>(word_sequence);
				solution.add(word);
				ll.add(solution);
			}
		}
	}

	return result;
}
*/

/**
 * Version_2

public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
	 HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
	 List<List<String>> result = new ArrayList<List<String>>();
	 
	 if(wordList.size() == 0){
		 return result;
	 }
	 
	 int min = Integer.MAX_VALUE;
	 
	 Queue<String> queue = new LinkedList<String>();
	 queue.offer(beginWord);
	 
	 HashMap<String, Integer> ladder = new HashMap<String, Integer>();
	 // initialize the ladder map
	 for(String word: wordList){
		 ladder.put(word, min);
	 }
	 // initialize the first generation
	 ladder.put(beginWord, 0);
	 
	 wordList.add(endWord);
	 
	 while(!queue.isEmpty()){
		 String word = queue.poll();
		 int step = ladder.get(word);
		 if(step > min)
			 break;
		
		 for (int i = 0; i < word.length(); i++){
			 StringBuilder newWord =  new StringBuilder(word);
			 for(char ch = 'a'; ch <= 'z'; ch++){
				 newWord.setCharAt(i, ch);
				 String new_word = newWord.toString();
				 if(ladder.containsKey(new_word)){
					 if(step > ladder.get(new_word))
						 continue;
					 else if(step < ladder.get(new_word)){
						 queue.add(new_word);
						 ladder.put(new_word, step);
					 }
					 
					 if(!map.containsKey(new_word)){
						 ArrayList<String> list= new ArrayList<String>();
						 map.put(new_word, list);
					 }
					 map.get(new_word).add(word);
					 
					 if(new_word.equals(endWord)){
						 min = step;
					 }
				 }
			 }
		 }
			 
	 }
	 
	 result = construct_list(beginWord, endWord, result, map);
	 
	 return result;
}


private static List<List<String>> construct_list(String start, String end, List<List<String>> result, HashMap<String, ArrayList<String>> map) {
	ArrayList<String> sol = new ArrayList<String>();
	sol.add(start);
	Queue<ArrayList<String>> queue = new LinkedList<ArrayList<String>>();
	queue.offer(sol);
	while(!queue.isEmpty()){
		ArrayList<String> word_sequence = queue.poll();
		String last_word = word_sequence.get(word_sequence.size() - 1);
		if(!map.containsKey(last_word)){
			continue;
		}
		for(String word: map.get(last_word)){
			if(word.equals(end)){
				if(result.isEmpty() || result.get(0).size() > word_sequence.size()){
					ArrayList<String> solution = new ArrayList<String>(word_sequence);
					solution.add(word);
					result.add(solution);
				}
			}	
			if((result.isEmpty() || result.get(0).size() > word_sequence.size() + 1)
					&& !word_sequence.contains(word)){
				ArrayList<String> solution = new ArrayList<String>(word_sequence);
				solution.add(word);
				queue.add(solution);
			}
		}
	}
	return result;
}	
*/
