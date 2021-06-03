package in.inishant.practice.lc;
/**
 * 
 * Given an integer array nums, find the contiguous subarray (containing at least one number),
 *  which has the largest sum and return its sum.
 *  
 * state : dp[i] = {max_val, min_val (-ve max)}
 * base case = dP[0]= 0 for both max and min
 *   transition formula: :  dp[i]max = max(dp(i-1)max*i,i) if i > 0
 *                          dp[i]max = max(dp(i-1)min * i,i) ifi>0
 * order of iteration: i starts 0 to forward 
 * Answer : dp(i)max
 * 
 * if you require array go backward. from solution max value to first
 * 
 */
public class MaximumProductSubarray {
    public static void main(String[] args) {
        int[] nums = {-2,0,-1};
        System.out.println(maxProduct(nums));
    }

    public static int maxProduct(int[] nums) {
        int n= nums.length;
        int[] maxdp = new int[n];
        int[] mindp = new int[n];
        int maxProduct=nums[0];
        maxdp[0]= nums[0];
        mindp[0]= nums[0];
        for(int i=1;i<n;i++){
            int num = nums[i];
            if(num == 0){
                maxdp[i] =num;
                mindp[i] =num;
                maxProduct= Math.max(maxProduct,num);
            }else if(num >0){
                maxdp[i] = Math.max(maxdp[i-1]*num,num);
                maxProduct = Math.max(maxProduct,maxdp[i]);
                mindp[i]= Math.min(mindp[i-1]*num,num);
            }else{
                maxdp[i] = Math.max(mindp[i-1]*num,num);
                maxProduct = Math.max(maxProduct,maxdp[i]);
                mindp[i]= Math.min(maxdp[i-1]*num,num);
            }
        }
        return maxProduct;
    }
}
