class Solution {
    public int maxProfit(int[] prices, int fee)
    {
        int dp[][]= new int[prices.length][2];
        for(int i=0;i<prices.length;i++)
        {
           
                Arrays.fill(dp[i],-1);
            
        }
        return solve(prices,0,1,dp,fee);
    }
    public int solve(int arr[],int i,int buy,int dp[][],int fee)
    {
        if(i==arr.length)
        return 0;
       
        if(dp[i][buy]!=-1)
        return dp[i][buy];
        if(buy==1)
        {
            return dp[i][buy]= Math.max((-arr[i]+solve(arr,i+1,0,dp,fee)),solve(arr,i+1,1,dp,fee));
        }
        else
        {
return dp[i][buy]=Math.max((arr[i]-fee+solve(arr,i+1,1,dp,fee)),solve(arr,i+1,0,dp,fee));
        }
    }
}