class Solution {
    public int numSquares(int n) {
        boolean arr[]= new boolean[n+1];
        int c=0;
        for(int i=1;i*i<=n;i++)
        {
            arr[i*i]=true;
            c++;
        }
        int a[]= new int[c];
        int k=0;
        for(int i=0;i<=n;i++)
        {
            if(arr[i]==true)
            a[k++]=i;
        }
    int dp[][]= new int[c][n+1];
    for(int i=0;i<c;i++)
    {
        for(int j=1;j<=n;j++)
        {
            if(a[i]==j)
            dp[i][j]=1;
            int take=(int)1e9;
            if(j-a[i]>=0)
             take=dp[i][j-a[i]]+1;
            int nottake=(int)1e9;
            if(i-1>=0)
           nottake=dp[i-1][j];
            dp[i][j]=Math.min(take,nottake);
        }
    }
    return dp[c-1][n];

    }
   
}