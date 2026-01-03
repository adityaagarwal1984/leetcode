class Solution {
    public int findTargetSumWays(int[] nums, int target) {
       
        
        int sum=0;
        for(int num:nums)
        sum+=num;
        
        int tar=(target+sum)/2;
        if(Math.abs(target)>sum || (target+sum)%2!=0)
        return 0;
         int dp[][]= new int[nums.length][tar+1];
         for(int i=0;i<nums.length;i++)
        Arrays.fill(dp[i],-1);
        return find(nums,tar,nums.length-1,dp);
    }
    public int find(int arr[],int tar,int idx,int dp[][])
    {
        
        if(idx==0)
        {
            if(arr[idx]==tar && tar==0)
            return 2;
            else if(arr[idx]==tar || tar==0)
            return 1;
            else
            return 0;
        }
        if(dp[idx][tar]!=-1)
        return dp[idx][tar];
        int not=find(arr,tar,idx-1,dp);
        int take=0;
        if(arr[idx]<=tar)
        take=find(arr,tar-arr[idx],idx-1,dp);
        return dp[idx][tar]= take+not;
    }
}