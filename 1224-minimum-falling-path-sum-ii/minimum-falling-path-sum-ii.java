class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n= matrix.length;
        int min=Integer.MAX_VALUE;
        int arr[][]= new int[n][n];
        for(int i=0;i<n;i++)
        {
            Arrays.fill(arr[i],Integer.MIN_VALUE);
        }
        for(int i=0;i<n;i++)
        {
        int a=path(matrix,0,i,n,arr);
        min=Math.min(min,a);
        }
        return min;
        
    }
    public int path(int [][]matrix,int i, int j,int n,int arr[][])
    {
        if(i==n || j==n || j<0)
        return Integer.MAX_VALUE;
        if(i==n-1)
        return matrix[i][j];
        if(arr[i][j]!=Integer.MIN_VALUE)
        return arr[i][j];

        int min=Integer.MAX_VALUE;
        
        for(int k=0;k<n;k++)
        {
            if(k!=j)
            {
                int next= path(matrix,i+1,k,n,arr);
                if(next!=Integer.MAX_VALUE)
                {
                    min=Math.min(min,next);
                }
            }
        }
        
        return arr[i][j]=matrix[i][j]+min;
    }
}