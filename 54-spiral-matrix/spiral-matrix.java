class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> ans= new ArrayList<>();
        int m= matrix.length;
        int n= matrix[0].length;
        int top=0;
        int left=0;
        int right=n-1;
        int bottom=m-1;
        while(top<=bottom && left<=right)
        {
            //move from left to right 
            if(top<=bottom)
            {
                for(int i=left;i<=right;i++)
                ans.add(matrix[top][i]);
            }
            top++;
            //move from top to bottom
             if(left<=right)
            {
                for(int i=top;i<=bottom;i++)
                ans.add(matrix[i][right]);
            }
            right--;
            //move right to left
             if(top<=bottom)
            {
                for(int i=right;i>=left;i--)
                ans.add(matrix[bottom][i]);
            }
            bottom--;
            //move from bottom to top
             if(left<=right)
            {
                for(int i=bottom;i>=top;i--)
                ans.add(matrix[i][left]);
            }
            left++;
        }
        return ans;
    }
}