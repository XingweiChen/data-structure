package LeetCode.Array;

import java.util.ArrayList;
import java.util.List;

public class Summary_Ranges {
	public static List<String> summaryRanges(int[] nums) {
		List<String> list= new ArrayList<String>();
		if(nums.length==1){
			list.add(nums[0]+"");
			return list;
		}
	    for(int i=0;i<nums.length;i++){
	    	int num = nums[i];
	    	while(i+1<nums.length&&(nums[i+1]-nums[i])==1){
	    		i++;
	    	}
	    	if(num != nums[i]){
	    		list.add(num + "->" + nums[i]);
	    	}else{
	    		list.add(num + "");
	    	}
	    }
	    return list;
    }
    
    public static void main(String[] args){
    	int[] nums ={-2147483648,-2147483647,2147483647}; 
    	List<String> result = summaryRanges(nums);
    	for(String s: result){
    		System.out.println(s);
    	}
    }
}
