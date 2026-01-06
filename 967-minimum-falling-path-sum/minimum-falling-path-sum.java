class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m= matrix.length;
        int n=matrix[0].length;
        int arr[][]= new int[m][n];
        for(int i=0;i<n;i++)
        arr[0][i]=matrix[0][i];
        for(int i=1;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                int a=Integer.MAX_VALUE;
                int b=Integer.MAX_VALUE;
                int c=Integer.MAX_VALUE;
    
                
                    a=arr[i-1][j];
                    if(j-1 >=0)
                    b=arr[i-1][j-1];
                    if(j+1<n)
                    c=arr[i-1][j+1];
                
                int min=Math.min(a,Math.min(b,c));
                arr[i][j]=matrix[i][j]+min;
            }
        }
        int min=Integer.MAX_VALUE;
        for(int num:arr[arr.length-1])
        min=Math.min(min,num);
        return min;
    }
}