package LeetCode.Array;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. 
 * This matrix has the following properties:
 * 
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * 
 * For example,Consider the following matrix:
 *		
 *		[
 *		  [1,   3,  5,  7],
 *		  [10, 11, 16, 20],
 *		  [23, 30, 34, 50]
 *		]
 *
 *	Given target = 3, return true.
 * 
 * @author Xingwei Chen
 */
public class Search_a_2D_Matrix {
	// solution_1 treated like a sorted list
    public boolean searchMatrix(int[][] matrix, int target) {
    	int row = matrix.length;
    	if(matrix == null || row == 0)
    		return false;
    	int col = matrix[0].length;
    	if(col == 0)
    		return false;
    	int end = matrix[0].length * row - 1, start = 0, mid;
    	while(start <= end){
    		mid = (start + end) / 2;
	    	if(matrix[mid / col][mid % col] == target)
	    		return true;
	    	else if(matrix[mid / col][mid % col] > target)
	    		end = mid - 1;
	    	else
	    		start = mid + 1;
	    		
    	}
		return false; 
    }
    
    //solution_2, 2D binary search
    public boolean searchMatrix2(int[][] matrix, int target) {
    	int row_num = matrix.length;
    	if(matrix == null || row_num == 0)
    		return false;
    	int col_num= matrix[0].length;
    	if(col_num == 0)
    		return false;
    	int begin = 0, end = row_num * col_num - 1;
    	
    	while(begin <= end){
    		int mid = (begin + end) / 2;
    		int mid_value = matrix[mid/col_num][mid%col_num];
    		
    		if( mid_value == target){
    			return true;
    		
    		}else if(mid_value < target){
    			//Should move a bit further, otherwise dead loop.
    			begin = mid+1;
    		}else{
    			end = mid-1;
    		}
    	}
    	
    	return false;
    }
    
    public static void main(String[] args){
    	Search_a_2D_Matrix test = new Search_a_2D_Matrix();
    	//{1}, {3}
    	//{1,3,5,7}, {10,11,16,20}, {23,30,34,50}
    	//{1 ,3}
    	//{3}
    	int[][] matrix = {{3}};
    	System.out.println(test.searchMatrix(matrix, 3));
    }
}
