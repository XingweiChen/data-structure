package LeetCode.Array;

/**
 * According to the Wikipedia's article: "The Game of Life, also known simply as Life, 
 * is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
 * 
 * Given a board with m by n cells, each cell has an initial state live (1) or dead (0). 
 * Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following
 * four rules (taken from the above Wikipedia article):
 * 		Any live cell with fewer than two live neighbors dies, as if caused by under-population.
 * 		Any live cell with two or three live neighbors lives on to the next generation.
 * 		Any live cell with more than three live neighbors dies, as if by over-population..
 * 		Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 * 
 * Write a function to compute the next state (after one update) of the board given its current state.
 * 
 * Follow up: 
 * 		Could you solve it in-place? Remember that the board needs to be updated at the same time: 
 * 			You cannot update some cells first and then use their updated values to update other cells.
 * 		In this question, we represent the board using a 2D array. In principle, the board is infinite, 
 * 			which would cause problems when the active area encroaches the border of the array. 
 * 			How would you address these problems?
 * 
 * 
 * @author Xingwei Chen
 *
 */
public class Game_of_Life {
	/**
	 * [2nd bit, 1st bit] = [next state, current state]
	 * 
	 * 	- 00  dead (next) <- dead (current)
	 * 	- 01  dead (next) <- live (current)  
	 * 	- 10  live (next) <- dead (current)  
	 * 	- 11  live (next) <- live (current) 
	 */
    public void gameOfLife(int[][] board) {
    	if (board == null || board.length == 0) 
    		return;

    	int rows = board.length, columns = board[0].length;
    	for(int i = 0; i < rows; i++){
    		for(int j= 0; j < columns; j++){
    			int lives = liveNeighbors(board, rows, columns, i , j);
    			
    			// Any live cell with two or three live neighbors lives on to the next generation.
    			if(board[i][j] == 1 && (lives == 2 || lives == 3)){
    				// Make the 2nd bit 1: 00 --> 10
    				board[i][j] = 3;
    			}
    			
    			// Any dead cell with exactly three live neighbors becomes a live cell
    			if(board[i][j] == 0 && lives == 3){
    				// Make the 2nd bit 1: 00 --> 10
    				board[i][j] = 2;
    			}
    		}
    	}
    	
    	for(int i=0; i< rows; i++){
    		for(int j= 0; j < columns; j++){
    			// move to next generation.
    			board[i][j] >>= 1;
    		}
    	}
    }
    
    public int liveNeighbors(int[][] board, int rows, int columns, int i, int j){
		int lives = 0;
		// 很好的用简单的代码规避了边缘的处理情况
		for(int x = Math.max(i - 1, 0); x <= Math.min(i + 1, rows - 1); x++){
			for(int y = Math.max(j - 1, 0); y <= Math.min(j + 1, columns - 1); y++){
				lives += board[x][y] & 1;
			}
		}
    	
		lives -= board[i][j] & 1;
    	return lives;

    }
}
