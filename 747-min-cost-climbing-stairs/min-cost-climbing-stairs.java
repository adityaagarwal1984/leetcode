class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int dp[]= new int[cost.length+1];
        int n=cost.length;
        
        for(int i=n-1;i>=0;i--)
        {
            if(i>n-3)
            dp[i]=cost[i];
            else
            
            dp[i]=cost[i]+Math.min(dp[i+1],dp[i+2]);
        }
        return Math.min(dp[0],dp[1]);
    }
}