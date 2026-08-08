class Solution {
    public int islandPerimeter(int[][] grid) {
        int perimeter=0;
        int row_size= grid.length;
        int col_size= grid[0].length;
        for(int i=0;i<row_size;i++)
        {
            for(int j=0;j<col_size;j++)
            {
                if(grid[i][j]==1)
                {
                    return dfs(grid,i,j,row_size, col_size);
                }
            }
        }
        return perimeter;
    }
    public int dfs(int grid[][],int i,int j,int m,int n)
    {
        if(i<0 || i>=m || j<0 || j>=n || grid[i][j]==0)
        {
            return 1;
        } 
        if(grid[i][j]==2) return 0;
        int ans=0;
        grid[i][j]=2;
        ans+= dfs(grid,i,j+1,m,n)+ dfs(grid,i,j-1,m,n)+ dfs(grid,i+1,j,m,n)+ dfs(grid,i-1,j,m,n);
        return ans;

    }
}