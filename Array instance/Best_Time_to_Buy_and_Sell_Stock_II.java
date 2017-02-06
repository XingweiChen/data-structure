package LeetCode.Array;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * 
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like 
 * (ie, buy one and sell one share of the stock multiple times).
 *  
 * However, you may not engage in multiple transactions at the same time 
 * (ie, you must sell the stock before you buy again).
 * 
 * @author Xingwei Chen
 */

// Input: [7, 1, 5, 3, 6, 4]
//
public class Best_Time_to_Buy_and_Sell_Stock_II {
    public int maxProfit(int[] prices) {
    	int cumulate = 0;
    	if(prices != null && prices.length != 0){
    		int postMax = prices[prices.length - 1], diff;
	        for(int i = prices.length - 2; i >= 0; i++){
	        	diff = postMax - prices[i];
	        	if ((diff > 0)){
	        		cumulate += diff;
	        		postMax = prices[i];
	        	}else{
	        		postMax = Math.max(postMax, prices[i]);
	        	}
	        	
	        }
        }
        return cumulate;
    }
    
    public static void main(String[] args){
    	Best_Time_to_Buy_and_Sell_Stock_II obj = new Best_Time_to_Buy_and_Sell_Stock_II();
    	int[] prices = {7, 1, 5, 3, 6, 4};
    	System.out.print(obj.maxProfit(prices));
    }
}
