class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int num:nums)
        sum+=num;
        if(sum%2!=0)
        return false;
        int tar=sum/2;
        boolean dp[][]= new boolean[nums.length][tar+1];
        for(int i=0;i<nums.length;i++)
        dp[i][0]=true;
        for(int j=1;j<=tar;j++)
        {
            if(nums[0]==j)
            dp[0][j]=true;
            
        }
        for(int i=1;i<nums.length;i++)
        {
            for(int j=0;j<=tar;j++)
            {
                boolean nottake=dp[i-1][j];
        boolean take=false;
        if(nums[i]<=j)
        take=dp[i-1][j-nums[i]];
        dp[i][j]= take|nottake;
            }
        }
        return dp[nums.length-1][tar];
    }
   
}