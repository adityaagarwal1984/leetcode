class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int arr[]= new int[2];
        int row=0;
        int c=0;
        for(int i=0;i<mat.length;i++)
        {
            int s=0;
            for(int j=0;j<mat[0].length;j++)
            {
                if(mat[i][j]==1)
                s++;
            }
            if(c<s)
            {
                c=s;
                arr[0]=i;
                arr[1]=c;
            }

        }
        return arr;
        
    }
}