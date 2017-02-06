package LeetCode.Array;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * 
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 * 
 * Note:
 * 		You may not engage in multiple transactions at the same time 
 * 		(ie, you must sell the stock before you buy again).
 * 
 * @author Xingwei Chen
 */
public class Best_Time_to_Buy_and_Sell_Stock_III {
    public int maxProfit(int[] prices) {
        int hold1 = Integer.MIN_VALUE, hold2 = Integer.MIN_VALUE;
        int release1 = 0, release2 = 0;
        for(int i:prices){                              // Assume we only have 0 money at first
            // find 2nd largest profit one(based on the largest one)
        	release2 = Math.max(release2, hold2+i);     // The maximum if we've just sold 2nd stock so far.
            hold2    = Math.max(hold2,    release1-i);  // The maximum if we've just buy  2nd stock so far.
            // this progress will find the largest profit one before the last loop
            release1 = Math.max(release1, hold1+i);     // The maximum if we've just sold 1nd stock so far.
            hold1    = Math.max(hold1,    -i);          // The maximum if we've just buy  1st stock so far. 
        }
        return release2; ///Since release1 is initiated as 0, so release2 will always higher than release1.
    }
	
    public static void main(String[] args){
    	Best_Time_to_Buy_and_Sell_Stock_III obj = new Best_Time_to_Buy_and_Sell_Stock_III();
    	int[] prices = {7, 5, 8, 2, 3, 4, 6, 1, 9};
    	System.out.print(obj.maxProfit(prices));
    }
}
