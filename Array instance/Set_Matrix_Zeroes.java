package LeetCode.Array;

/**
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 * 
 * @author Xingwei Chen
 */
public class Set_Matrix_Zeroes {
	/*
	 * 用第一行和第一列来做标记, 由于标记一定比扫描的位置慢所以可以实现
	 */
    public void setZeroes(int[][] matrix) {
        boolean fr = false,fc = false;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    if(i == 0) fr = true;
                    if(j == 0) fc = true;
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for(int i = 1; i < matrix.length; i++) {
            for(int j = 1; j < matrix[0].length; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if(fr) {
            for(int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }
        if(fc) {
            for(int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }
    
    public static void main(String[] args){
    	Set_Matrix_Zeroes test = new Set_Matrix_Zeroes();
    	//{0},{1}
    	int[][] matrix = {{0},{1}};
    	test.setZeroes(matrix);
    	for(int[] line: matrix){
    		for(int num: line){
    			System.out.print(num);
    		}
    		System.out.println();
    	}
    }
}
