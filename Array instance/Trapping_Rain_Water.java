package LeetCode.Array;

import java.util.Stack;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, 
 * compute how much water it is able to trap after raining.
 * 
 * For example, 
 * 
 * 		Given [0,1,0,2,1,0,1,3,2,1,2,1], 
 * 		return 6
 * 
 * @author Xingwei Chen
 */
public class Trapping_Rain_Water {
    public int trap(int[] height) {
    	int accumulate = 0, length = height.length;
    	if(height == null || length == 0)
    		return accumulate;
    	int left = 0, count = 0;
    	// 从左往右, 计算水的存贮量
    	for(int i = 1; i < length; i++){
    		if(height[i] < height[left]){
    			count += height[i];
    		}else{
    			if(height[left] != 0 && i - left > 1)
    				accumulate += height[left] * (i - left - 1) - count;
    			count = 0;
    			left = i;
    		}
    	}
    	// 从右到最高的柱子计算水的存储量
    	int right = length - 1;
    	for(int i = length - 1; i >= left; i--){
    		if(height[i] < height[right]){
    			count += height[i];
    		}else{
    			if(height[right] != 0 && right - i > 1)
    				accumulate += height[right] * (right - i - 1) - count;
    			count = 0;
    			right = i;
    		}
    	}
        return accumulate;
    }
    
    public static void main(String[] args){
    	Trapping_Rain_Water test = new Trapping_Rain_Water();
    	// {0,1,0,2,1,0,1,3,2,1,2,1}
    	int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
    	System.out.println(test.trap(height));
    }
}
