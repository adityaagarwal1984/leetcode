class Solution {
    public int superEggDrop(int k, int n) {
        int dp[][]= new int[k+1][n+1];
        for(int i=0;i<=k;i++)
        Arrays.fill(dp[i],-1);
        return solve(k,n,dp);
    }
    public int solve(int k,int n,int dp[][])
    {
        if(k==1)
        return n;
        if(n==1 || n==0)
        return n;
        if(dp[k][n]!=-1)
        return dp[k][n];
        int low=1;
        int high=n;
        int ans=Integer.MAX_VALUE;
        while(low<=high)
        {
       int mid=(low+high)/2;
            int breaking=solve(k-1,mid-1,dp);
            int not=solve(k,n-mid,dp);
            int temp=1+Math.max(breaking,not);
            ans=Math.min(ans,temp);
            if(breaking<not)
            {
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }

            
        }
        return dp[k][n]=ans;

    }
}