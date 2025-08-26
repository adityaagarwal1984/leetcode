class Solution {
    public int areaOfMaxDiagonal(int[][] arr) {
        int max=Integer.MIN_VALUE;
        int idx=0;
        int val=0;

        for(int i=0;i<arr.length;i++)
        
        {
            int l=arr[i][0];
        int b=arr[i][1];
            int diff=(l*l+b*b);
            if(diff>max)
            {
                max=diff;
                idx=i;
                
            }
            else if(diff==max)
            {
                if(arr[idx][0]*arr[idx][1]<arr[i][0]*arr[i][1])
                idx=i;

            }
        }
        return arr[idx][0]*arr[idx][1];
        
    }
}