class Solution {
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;

        int arr[][]= new int[m][n];
        for(int i=0;i<m;i++)
        {
            Arrays.fill(arr[i],-1);
        }
        return path(0,0,m,n,grid,arr);
    }
    public int path(int i,int j,int m,int n,int a[][],int arr[][])
    {
        if(i==m || j==n)
        return Integer.MAX_VALUE;
        if(i==m-1 && j==n-1)
        return a[m-1][n-1];
        if(arr[i][j]!=-1)
        return arr[i][j];
       int s1= path(i+1,j,m,n,a,arr);
       int s2=path(i,j+1,m,n,a,arr);
       return arr[i][j]= a[i][j]+Math.min(s1,s2);
    }
}