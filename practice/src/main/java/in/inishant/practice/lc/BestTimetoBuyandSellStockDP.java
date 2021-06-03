package in.inishant.practice.lc;
/**
 * 
 * maximize your profit by choosing a single day to buy one stock 
 * and choosing a different day in the future to sell that stock.
 *  
 * state : dp[i] = max profit 
 * base case = dP[0]= 0
 * transition formula: :  dp[i] = max(i-min_val,0)
 * order of iteration: i starts 0 to forward 
 * Answer : dp(i)max
 * 
 *
 * 
 */
public class BestTimetoBuyandSellStockDP {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int min_val = prices[0], max_profit=0;
        for(int i=1;i<prices.length;i++){
            min_val = Math.min(min_val,prices[i]);
            max_profit = Math.max(max_profit,prices[i]-min_val);
        }
        return max_profit;
    }
}
