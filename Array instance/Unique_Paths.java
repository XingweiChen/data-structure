package LeetCode.Array;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * 
 * The robot can only move either down or right at any point in time. 
 * The robot is trying to reach the bottom-right corner of the grid 
 * (marked 'Finish' in the diagram below).
 * 
 * How many possible unique paths are there?
 * 
 * @author Xingwei Chen
 */
public class Unique_Paths {
	//Solution_1: 动态规划
	public int uniquePaths(int m, int n) {
        int[][] matrix = new int[m][n];
        for(int i = 0; i < n; i++)
        	matrix[0][i] = 1;
        for(int i = 1; i < m; i++)
        	matrix[i][0] = 1;
        for(int i = 1; i < m; i++){
        	for(int j = 1; j < n; j++){
        		matrix[i][j] = matrix[i][j - 1] + matrix[i - 1][j];
        	}
        }
		return matrix[m - 1][n - 1];
    }
    
    // solution_2: 公式计算
	public int uniquePaths2(int m, int n) {
	    int N = n + m - 2;// how much steps we need to do
	    int k = m - 1; // number of steps that need to go down
	    double res = 1;
	    // here we calculate the total possible path number 
	    // Combination(N, k) = n! / (k!(n - k)!)
	    // reduce the numerator and denominator and get
	    // C = ( (n - k + 1) * (n - k + 2) * ... * n ) / k!
	    for (int i = 1; i <= k; i++)
	        res = res * (N - k + i) / i;
	    return (int)res;
	}
	
    public static void main(String[] args){
    	Unique_Paths test = new Unique_Paths();
    	System.out.println(test.uniquePaths(3, 7));
    }
}
