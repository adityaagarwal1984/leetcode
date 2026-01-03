class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[][]= new int[coins.length][amount+1];
        for(int i=0;i<coins.length;i++)
        Arrays.fill(dp[i],-1);
       noofcoins(coins,amount,coins.length-1,dp);
        if(dp[coins.length-1][amount]>=(int)1e9)
        return -1;
        else
        return dp[coins.length-1][amount];
    }
    public void noofcoins(int coins[],int amount,int idx,int dp[][])
    {
        for(int i=0;i<=amount;i++)
        {
            if(i%coins[0]==0)
            {
                dp[0][i]= i/coins[0];
            }
            else
            {
            dp[0][i]= (int)1e9;
            }
        }
        for(int i=1;i<coins.length;i++)
        {
            for(int j=0;j<=amount;j++)
        {
        int nottake=dp[i-1][j];
        int take=(int)1e9;
        if(j>=coins[i])
        {
            take=1+dp[i][j-coins[i]];
        }
         dp[i][j]=Math.min(nottake,take);
        }
        }

    }
}