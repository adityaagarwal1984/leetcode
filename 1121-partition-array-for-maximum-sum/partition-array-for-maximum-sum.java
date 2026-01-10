class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int dp[]= new int[arr.length];
        Arrays.fill(dp,-1);
        return maxsum(arr,k,0,dp);
    }
    public int maxsum(int arr[],int k,int i,int dp[])
    {
        if(i==arr.length)
        return 0;
        if(dp[i]!=-1)
        return dp[i];
        int max=Integer.MIN_VALUE;
        int l=0;
        int currsum=0;
        int maxi=Integer.MIN_VALUE;
        for(int j=i;j< Math.min(i+k,arr.length);j++)
        {
            l++;
            max=Math.max(max,arr[j]);
            currsum=(l*max)+maxsum(arr,k,j+1,dp);
            maxi=Math.max(maxi,currsum);
           

        }
        return dp[i]=maxi;

    }
}