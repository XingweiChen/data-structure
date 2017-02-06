package LeetCode.Array;

/**
 * Follow up for "Unique Paths":
 * 
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * 
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * 
 * For example,
 * 
 * There is one obstacle in the middle of a 3x3 grid as illustrated below.
 *
 *				[
 *				  [0,0,0],
 *				  [0,1,0],
 *				  [0,0,0]
 *				]
 * The total number of unique paths is 2.
 * Note: m and n will be at most 100.
 * 
 * @author Xingwei Chen
 */
public class Unique_Paths_II {
	public int uniquePathsWithObstacles(int[][] obstacleGrid){
		int rows = obstacleGrid.length;
		if(obstacleGrid == null || rows == 0)
			return 0;
		int cols = obstacleGrid[0].length;
		if(cols == 0 || obstacleGrid[rows - 1][cols - 1] == 1 ||obstacleGrid[0][0] == 1)
			return 0;
		int way = 1;
        for(int i = 0; i < cols; i++){
        	if(obstacleGrid[0][i] == 1){
        		obstacleGrid[0][i] = 0;
        		way = 0;
        	}
        	obstacleGrid[0][i] = way;
        }
        way = 1;
        for(int i = 1; i < rows; i++){
        	if(obstacleGrid[i][0] == 1){
        		obstacleGrid[i][0] = 0;
        		way = 0;
        	}
        	obstacleGrid[i][0] = way;
        }
        for(int i = 1; i < rows; i++){
        	for(int j = 1; j < cols; j++){
        		if(obstacleGrid[i][j] == 1)
        			obstacleGrid[i][j] = 0;
        		else
        			obstacleGrid[i][j] = obstacleGrid[i][j - 1] + obstacleGrid[i - 1][j];
        	}
        }
		return obstacleGrid[rows - 1][cols - 1];
    }
}
