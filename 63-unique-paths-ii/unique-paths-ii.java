class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m= obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int arr[][]= new int[m][n];
        for(int i=0;i<m;i++)
        Arrays.fill(arr[i],-1);
        if(obstacleGrid[m-1][n-1]==1)
        return 0;
        
        return path(0,0,m,n,arr,obstacleGrid);
    }
    public int  path(int i,int j,int m,int n,int arr[][],int a[][])
    {
        if(i==m || j==n)
        return 0;
        if(i==m-1 && j==n-1)
        return 1;
        if(a[i][j]==1)
        return 0;
        if(arr[i][j]!=-1)
        return arr[i][j];
        
        int right=path(i,j+1,m,n,arr,a);
        
        int bottom= path(i+1,j,m,n,arr,a);
        return  arr[i][j]=right+bottom;
    }
}
        
    