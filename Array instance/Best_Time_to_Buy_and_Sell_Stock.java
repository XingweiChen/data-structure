package LeetCode.Array;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction 
 * (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 * Example 1:
 * 		Input: [7, 1, 5, 3, 6, 4]
 * 		Output: 5
 * maximum profit is difference = 6-1 = 5 (not 7-1 = 6)
 * 
 * Example 2:
 * 		Input: [7, 6, 4, 3, 1]
 * 		Output: 0
 * 
 * In this case, no transaction is done, i.e. max profit = 0.
 * 
 * @author Xingwei Chen
 */
public class Best_Time_to_Buy_and_Sell_Stock {
    public int maxProfit(int[] prices) {
    	int maximum = 0;
    	if(prices != null && prices.length != 0){
    		int minpre = prices[0];
	        for(int i = 1; i < prices.length; i++){
	        	maximum = Math.max(maximum, (prices[i] - minpre > 0) ? prices[i] - minpre: 0);
	        	minpre = Math.min(minpre, prices[i]);
	        }
        }
        return maximum;
    }
}
