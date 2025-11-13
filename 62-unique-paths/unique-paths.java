class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][]= new int[m][n];
        for(int i=0;i<m;i++)
        {
            Arrays.fill(dp[i],-1);
        }
        return paths(0,0,m,n,dp);
        
    }
    public int paths(int i,int j,int m,int n,int arr[][])
    {
        if(i>=m || j>=n)
        return 0;
        if(i==m-1 && j==n-1)
        return 1;
        if(arr[i][j]!=-1)
        return arr[i][j];
        int right=paths(i,j+1,m,n,arr);
        int down=paths(i+1,j,m,n,arr);
        return arr[i][j]= right+down;

    }
}