class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int dp[]= new int[arr.length];
        Arrays.fill(dp,-1);
        return maxsum(0,arr,k,dp);
        
    }
    public int maxsum(int i,int arr[],int k,int dp[])
    {
        if(i==arr.length)
        return 0;
        if(dp[i]!=-1)
        return dp[i];
        int l=0;
        int max=Integer.MIN_VALUE;
        int maxi=0;
        for(int x=i;x<Math.min(arr.length,i+k);x++)
        {
            l++;
            max=Math.max(max,arr[x]);
            int sum=max*l+maxsum(x+1,arr,k,dp);
            maxi=Math.max(maxi,sum);



        }
        return  dp[i]=maxi;
    }
}