class Solution {
    public int maxConsistentColumns(int[][] grid, int limit) {
        int m= grid.length;
        int n= grid[0].length;
        int arr[]= new int[n];
        Arrays.fill(arr,1);
        for(int i=1;i<n;i++)
        {
            for(int j=i-1;j>=0;j--)
            {
                boolean right=true;
                for(int x=0;x<m;x++)
                {
                    if(Math.abs(grid[x][i]- grid[x][j])>limit)
                    {
                        right=false;
                        break;
                    }
                }
                if(right)
                {
                    arr[i]= Math.max(arr[i], 1+ arr[j]);
                }
            }
            
        }
        int ans=1;
        for(int num: arr)
        {
            ans= Math.max(ans,num);
        }
        return ans;
    }
}