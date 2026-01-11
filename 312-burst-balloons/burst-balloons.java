class Solution {
    public int maxCoins(int[] nums) {
        int arr[]= new int[nums.length+2];
        int i=0;
        int j=1;
        arr[0]=arr[nums.length+1]=1;
        int dp[][]= new int[nums.length+2][nums.length+2];
        for(int k=0;k<nums.length+2;k++)
        Arrays.fill(dp[k],Integer.MIN_VALUE);
        while(i<nums.length)
        {
            arr[j]=nums[i];
            i++;
            j++;
        }
        return solve(arr,1,arr.length-2,dp);
        
    }
    public int solve(int nums[],int i,int j,int dp[][])
    {
        if(i>j)
        return 0;
        if(dp[i][j]!=Integer.MIN_VALUE)
        return dp[i][j];
        int max=Integer.MIN_VALUE;
        for(int k=i;k<=j;k++)
        {
            int sum=(nums[k]*nums[i-1]*nums[j+1])+solve(nums,i,k-1,dp)+solve(nums,k+1,j,dp);
            max=Math.max(max,sum);
        }
        return dp[i][j]=max;
    }
}