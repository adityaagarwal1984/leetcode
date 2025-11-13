class Solution {
    public int rob(int[] nums) {
    int arr[]= new int[nums.length];
    Arrays.fill(arr,-1);
    return theft(nums,nums.length-1,arr);
        
    }
    public int theft(int arr[],int i,int dp[])
    {
        if(i<0)
        return 0;
        if(dp[i]!=-1)
        return dp[i];
        int nottake=theft(arr,i-1,dp);
        int take= arr[i]+theft(arr,i-2,dp);
        return dp[i]=Math.max(take,nottake);


    }
}