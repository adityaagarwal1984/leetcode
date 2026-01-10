class Solution {
    public boolean stoneGame(int[] piles) {
        
        int n=piles.length;
        int dp[][]= new int[n][n];
        for(int i=0;i<n;i++)
        Arrays.fill(dp[i],-1);
        int sum=0;
        for(int num:piles)
        sum+=num;
        int alice=diff(piles,0,piles.length-1,dp);
        int bob=sum-alice;
        if(alice>bob)
        return true;
        else
        return false;
    }
    public int diff(int arr[],int i,int j,int dp[][])
    {
        if(i>j)
        return 0;
        if(dp[i][j]!=-1)
        return dp[i][j];

        int a=arr[i]+diff(arr,i+2,j,dp);
        int b=arr[i]+diff(arr,i+1,j-1,dp);
        int c=arr[j]+diff(arr,i,j-2,dp);
        int d=arr[j]+diff(arr,i+1,j-1,dp);

        return dp[i][j]=Math.max(Math.max(Math.max(a,b),c),d);
    }
}