package LeetCode.Array;

/**
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 * 
 * For example,
 * 		Given n = 3,
 * 		You should return the following matrix:
 *					[
 *					 [ 1, 2, 3 ],
 *					 [ 8, 9, 4 ],
 *					 [ 7, 6, 5 ]
 *					]
 * 
 * @author Xingwei Chen
 */
public class Spiral_Matrix_II {
    public int[][] generateMatrix(int n) {
    	int[][] result = new int[n][n];
    	if(n == 0){
    		return result;
    	}
    	
        int rowBegin = 0;
        int rowEnd = n-1;
        int colBegin = 0;
        int colEnd = n - 1;
        int count = 1;
    	
        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            // Traverse Right
            for (int j = colBegin; j <= colEnd; j ++) {
                result[rowBegin][j] = count++;
            }
            rowBegin++;
            
            // Traverse Down
            for (int j = rowBegin; j <= rowEnd; j ++) {
                result[j][colEnd] = count++;
            }
            colEnd--;
            
            if (rowBegin <= rowEnd) {
                // Traverse Left
                for (int j = colEnd; j >= colBegin; j --) {
                    result[rowEnd][j] = count++;
                }
            }
            rowEnd--;
            
            if (colBegin <= colEnd) {
                // Traver Up
                for (int j = rowEnd; j >= rowBegin; j --) {
                    result[j][colBegin] = count++;
                }
            }
            colBegin ++;
        }
    	
		return result;
    }
    
    public static void main(String[] args){
    	Spiral_Matrix_II  test = new Spiral_Matrix_II();
    	int[][] result = test.generateMatrix(3);
    	for(int[] line: result){
    		for(int num: line){
    			System.out.print(num + " ");
    		}
    		System.out.println();
    	}
    }
}
