class Solution {
   
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int dp[][]= new int[n][n+1];
        for(int i=0;i<n;i++)
        {
            Arrays.fill(dp[i],-1);
        }
return ans(nums,0,-1,dp);
        
    }
    public int ans(int arr[],int i,int prev,int dp[][])
    {
        if(i==arr.length)
        return 0;
        if(dp[i][prev+1]!=-1)
        return dp[i][prev+1];
        int nottake=ans(arr,i+1,prev,dp);
        int take=0;
        if(prev==-1 || arr[i]>arr[prev]){
        take= 1+ans(arr,i+1,i,dp);
        
        }
        
        return dp[i][prev+1]= Math.max(take,nottake);
    }
}