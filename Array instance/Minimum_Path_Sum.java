package LeetCode.Array;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right 
 * which minimizes the sum of all numbers along its path.
 * 
 * Note: You can only move either down or right at any point in time.
 * 
 * @author Xingwei Chen
 */
public class Minimum_Path_Sum {
	//动态规划
    public int minPathSum(int[][] grid) {
    	int rows = grid.length;
    	if(grid == null || rows == 0)
    		return 0;
    	int cols = grid[0].length;
    	if(cols == 0)
    		return 0;
    	for(int i = 1; i < cols; i++)
    		grid[0][i] += grid[0][i - 1];
    	for(int j = 1; j < rows; j++)
    		grid[j][0] += grid[j - 1][0];
    	for(int row = 1; row < rows; row++){
    		for(int col = 1; col < cols; col++){
    			grid[row][col] = Math.min(grid[row -1][col], grid[row][col -1]) + grid[row][col];
    		}
    	}
		return grid[rows -1][cols - 1];
    }
    
    public static void main(String[] args){
    	Minimum_Path_Sum test = new Minimum_Path_Sum();
    	int[][] grid = {{1,2}, {1,1}};
    	System.out.println(test.minPathSum(grid));
    }
}
