class Solution {
    public int uniquePaths(int m, int n) {
        int arr[][]= new int[m][n];
        for(int i=0;i<m;i++)
        Arrays.fill(arr[i],-1);
        
        return path(0,0,m,n,arr);
    }
    public int  path(int i,int j,int m,int n,int arr[][])
    {
        if(i==m || j==n)
        return 0;
        if(i==m-1 && j==n-1)
        return 1;
        if(arr[i][j]!=-1)
        return arr[i][j];
        int right=path(i,j+1,m,n,arr);
        
        int bottom= path(i+1,j,m,n,arr);
        return  arr[i][j]=right+bottom;
    }
}