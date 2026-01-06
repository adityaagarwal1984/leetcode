class Solution {
    public int maxProfit(int[] prices) {
        int dp[][][]= new int[prices.length][2][3];
        for(int i=0;i<prices.length;i++)
        {
            for(int j=0;j<2;j++)
            {
                Arrays.fill(dp[i][j],-1);
            }
        }
        return solve(prices,0,1,2,dp);
    }
    public int solve(int arr[],int i,int buy,int cap,int dp[][][])
    {
        if(i==arr.length)
        return 0;
        if(cap==0)
        return 0;
        if(dp[i][buy][cap]!=-1)
        return dp[i][buy][cap];
        if(buy==1)
        {
            return dp[i][buy][cap]= Math.max((-arr[i]+solve(arr,i+1,0,cap,dp)),solve(arr,i+1,1,cap,dp));
        }
        else
        {
return dp[i][buy][cap]=Math.max((arr[i]+solve(arr,i+1,1,cap-1,dp)),solve(arr,i+1,0,cap,dp));
        }
    }
}