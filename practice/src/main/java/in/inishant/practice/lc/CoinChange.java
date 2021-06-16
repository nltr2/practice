package in.inishant.practice.lc;

import java.util.Arrays;

/**
 * 
 * given an integer array coins representing coins of different denominations
 * and an integer amount representing a total amount of money. Return the fewest
 * number of coins that you need to make up that amount. If that amount of money
 * cannot be made up by any combination of the coins, return -1
 * 
 * let represent 
 * given amount as S (as like sum)
 * denominations as d
 * create array dp of size S+1, 
 * where every index i represents amount from 0 to S and value represents min number of denominations
 *  
 * Fill with dp array with value S+1 as given big value ot represent that if at the end of the algo, if an index contians S+1 value which will mean that the coin cannot used to make up the amount.
 * 
 * 
 *  state : dp[i] = min number of coin denominations
 *  base case = dP[0]=0 
 *  transition formula: : dp[i] = min(dp[i-d]+1,dp[i]) 
 *  order of iteration: i starts 0 to  S 
 *  Answer : dp(S) : if dp[S] == S+1 return -1 else dp[S]
 * 
 *
 * 
 */
public class CoinChange {

    public static void main(String[] args) {

        int[]  coins = {1,2,5}; 
        int amount = 11;
        System.out.println(coinChange(coins, amount));
        
        int[]  coins1 = {2,}; 
        amount = 3;
        System.out.println(coinChange(coins1, amount));
    }

    public static int coinChange(int[] coins, int amount) {
        int [] dp =new int[amount+1];
        Arrays.fill(dp, amount+1);
        // base case
        dp[0]=0;
        for(int i=1;i<=amount;i++){
            for(int j=0;j<coins.length;j++){
                int curcoin =coins[j];
                // as i is less than current coin, so current coin cannot be used
                // e.g. for amount 3 if current coin is 5, there is no way '5' can be used in amount. 
                if(i<curcoin){
                    continue;
                } 
                dp[i] = Math.min(dp[i-curcoin]+1,dp[i]);
            }
        }
        return dp[amount]==amount+1?-1:dp[amount];
    }
}