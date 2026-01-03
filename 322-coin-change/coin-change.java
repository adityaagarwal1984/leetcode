class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[][]= new int[amount+1][coins.length];
        for(int i=0;i<amount+1;i++)
        Arrays.fill(dp[i],-1);
        int ans=noofcoins(coins,amount,coins.length-1,dp);
        if(ans>=(int)1e9)
        return -1;
        else
        return ans;
    }
    public int noofcoins(int coins[],int amount,int idx,int dp[][])
    {
        if(idx==0)
        {
            if(amount%coins[idx]==0)
            {
                return amount/coins[idx];
            }
            else
            {
                return (int)1e9;
            }
        }
        if(dp[amount][idx]!=-1)
        return dp[amount][idx];
        int nottake=noofcoins(coins,amount,idx-1,dp);
        int take=(int)1e9;
        if(amount>=coins[idx])
        {
            take=1+noofcoins(coins,amount-coins[idx],idx,dp);
        }
        return dp[amount][idx]=Math.min(nottake,take);

    }
}