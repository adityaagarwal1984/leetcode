class Solution {
    public boolean canPartition(int[] nums) {
        int n= nums.length;
        int s=0;
        for(int num:nums)
        s+=num;
        int arr[][]= new int[n][s/2+1];
        for(int i=0;i<n;i++)
        {
            Arrays.fill(arr[i],-1);
        }
        
        if(s%2==1)
        return false;
        return check(nums,s/2,nums.length-1,arr)==1;

        
    }
    public int check(int arr[],int tar,int i,int dp[][])
    {
        if(tar==0)
        return 1;
        if(i==0)
        return arr[i]==tar?1:0;
        if(dp[i][tar]!=-1)
        return dp[i][tar];
        int nottake=check(arr,tar,i-1,dp);
        int take=0;
        if(arr[i]<=tar)
        take=check(arr,tar-arr[i],i-1,dp);
        return  dp[i][tar]=take | nottake;
    }
}