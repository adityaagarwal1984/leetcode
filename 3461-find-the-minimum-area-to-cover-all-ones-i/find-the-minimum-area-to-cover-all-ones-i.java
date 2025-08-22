class Solution {
    public int minimumArea(int[][] grid) {
        int m= grid.length;
        int n=grid[0].length;
        int mini=Integer.MAX_VALUE;
        int minj=Integer.MAX_VALUE;
        int maxi=Integer.MIN_VALUE;
       int  maxj=Integer.MIN_VALUE;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==1)
                {
                    mini=Math.min(mini,i);
                    minj=Math.min(minj,j);
                    maxi=Math.max(maxi,i);
                    maxj=Math.max(maxj,j);
                }
            }
        }
        
        int h=maxj-minj+1;
        int v=maxi-mini+1;
        return h*v;
        
    }
}