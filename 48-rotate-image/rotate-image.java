class Solution {
    public void rotate(int[][] matrix) {
         transpose(matrix);
        for(int i=0;i<matrix.length;i++)
        {
            int j=0;
            while(j<matrix[0].length/2)
            {
                int temp=matrix[i][j];
                matrix[i][j]=matrix[i][matrix.length-j-1];
                matrix[i][matrix.length-j-1]=temp;
                j++;

            }
        }
   
        
    }
    public int[][] transpose(int a[][])
    {
        for(int i=0;i<a.length;i++)
        {
            for(int j=0;j<a[0].length;j++)
            {
                
                if (j > i) {
    int temp = a[i][j];
    a[i][j] = a[j][i];
    a[j][i] = temp;
}

            }
        }
        return a;
    }

}