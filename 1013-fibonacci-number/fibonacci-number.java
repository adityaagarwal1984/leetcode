class Solution {
    // public int fib(int n)
    // {
    //     if(n<=1)
    //     return n;
    //     return fib(n-1)+fib(n-2);
    // }
    public int fib(int n) {
        
    int dp[]= new int[n+1];
    for(int i=0;i<n+1;i++)
    {
        dp[i]=-1;
    }

     return f(n,dp);
        
    }
    public int f(int n,int dp[])
    {
        if(n<=1)
        return n;
        if(dp[n]!=-1)
        return dp[n];
        else
        return dp[n]= f(n-1,dp)+f(n-2,dp);
    }
}