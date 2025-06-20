class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int r=0;int c= mat[0].length-1;
        while(r<=c)
        {
           int mid=r+(c-r)/2;
           int row=max(mat,mat.length,mat[0].length,mid);
           int left=((mid-1)>=0)?mat[row][mid-1]:-1;
           int right=((mid+1)<mat[0].length)?mat[row][mid+1]:-1;
           if(mat[row][mid]>left && mat[row][mid]>right)
           return new int[]{row,mid};
           else if(mat[row][mid]<left)
           {
            c=mid-1;
           }
           else
           r=mid+1;
            
        }
        return new int[]{-1,-1};
        
    }
    public int max(int arr[][],int m,int n,int mid ){

        int maxi=0;
        for(int i=1;i<m;i++)
        {
            if(arr[i][mid]>arr[maxi][mid])
            maxi=i;
        }
        return maxi;

    }
}