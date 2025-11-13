class Solution {
    public int uniquePathsWithObstacles(int[][] a) {
        int dp[][]= new int[a.length][a[0].length];
        for(int i=0;i<a.length;i++)
        {
            Arrays.fill(dp[i],-1);
        }
        return raste(a,0,0,a.length,a[0].length,dp);

        
    }
    public int raste(int arr[][],int i,int j,int m,int n,int dp[][])
    {
        if(i>=m || j>=n)
        return 0;
        if( arr[i][j]==1)
        return 0;
        if(i==m-1 && j==n-1)
        return 1;
        
        if(dp[i][j]!=-1)
        return dp[i][j];
        int right=raste(arr,i,j+1,m,n,dp);
        int down=raste(arr,i+1,j,m,n,dp);
        return dp[i][j]=right+down;
    }
}