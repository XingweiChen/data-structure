package LeetCode.Array;

/**
 * Given a 2D binary matrix filled with 0's and 1's, 
 * find the largest rectangle containing only 1's and return its area.
 * 
 * For example
 * 
 * Given the following matrix:
 *
 *		1 0 1 0 0
 *		1 0 1 1 1
 *		1 1 1 1 1
 *		1 0 0 1 0
 * Return 6.
 * 
 * @author Xingwei Chen
 */
public class Maximal_Rectangle {
	public int maximalRectangle(char[][] matrix) {
	    if(matrix == null || matrix.length == 0) 
	    	return 0;
	    int m = matrix.length;
	    int n = matrix[0].length;
	    int[] height = new int[n], left = new int[n], right = new int[n];
	    for(int i=0; i <n;i++){
	    	right[i] = n;
	    }
	    int area = 0;
	    for(int i=0; i<m; i++) {
	        int cur_left = 0, cur_right = n;
	        // 基于上一层的结果计算这一层各column的高度
	        for(int j = 0; j < n; j++) { // compute height (can do this from either side)
	            if(matrix[i][j]=='1') 
	            	height[j]++; 
	            else 
	            	height[j]=0;
	        }
	        
	        // 基于上一层计算连续的左侧起始点
	        for(int j=0; j<n; j++) {
	            if(matrix[i][j]=='1')
	            	// 左侧取上一层和这一层最大的index
	            	left[j]= Math.max(left[j],cur_left);
	            else {
	            	left[j]=0; // let this left = 0 due to matrix[i][j] == '0'
	            	cur_left=j+1; // new start
	            }
	        }
	        // 计算连续的右侧起始点
	        for(int j=n-1; j>=0; j--) {
	            if(matrix[i][j]=='1')
	            	// 右侧取上一层和这一层最小的index
	            	right[j]= Math.min(right[j],cur_right);
	            else {
	            	right[j]=n;  // let this right = 5 due to matrix[i][j] == '0'
	            	cur_right=j; // new start
	            }    
	        }
	        // 因为height = 0, 所以讲matrix[i][j] == '0'处的left =0, right =5 不会导致结果偏大, 从而方面了通过比较
	        // right[j],cur_right以及left[j],cur_left来获取当前左侧和右侧的起始点
	        
	        
	        // compute the area of rectangle (can do this from either side)
	        // 相当于动态规划, 记录每一个点可能取到的最大值
	        for(int j=0; j<n; j++)
	        	area = Math.max(area,(right[j]-left[j])*height[j]);
	    }
	    return area;
	}
	
	public static void main(String[] args){
		Maximal_Rectangle test = new Maximal_Rectangle();
		char[][] matrix = {{'1','0','1','0','0'}, {'1','0','1','1','1'},
				{'1','1','1','1','1'}, {'1','0','0','1','0'}};
		int num = test.maximalRectangle(matrix);
		System.out.println(num);
	}
}
