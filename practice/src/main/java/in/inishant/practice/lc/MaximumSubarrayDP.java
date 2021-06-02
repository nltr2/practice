package in.inishant.practice.lc;
/**
 * 
 * Given an integer array nums, find the contiguous subarray (containing at least one number),
 *  which has the largest sum and return its sum.
 *  
 * state : dp[i] = max subarray 
 * base case = dP[0]= nums[0]
 *   transition formula: :  dp[i][j] = max(dp(i-1)+i,i)
 * order of iteration: i starts 0 to forward 
 * Answer : dp(i)max
 * 
 * if you require array go backward. from solution max value to first
 * 
 */
public class MaximumSubarrayDP {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
    public static int maxSubArray(int[] nums) {
        int maxVal = nums[0],n=nums.length;
        int[] dp =new int [n];
        dp[0] = nums[0];
        for(int i=1;i<n;i++ ){
            dp[i] = Math.max(dp[i-1]+nums[i], nums[i]);
            maxVal=Math.max(dp[i], maxVal);
        }
        return maxVal;
    }
}
