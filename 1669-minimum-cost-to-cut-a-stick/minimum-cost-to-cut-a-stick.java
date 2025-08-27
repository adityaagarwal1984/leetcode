class Solution {
    public int minCost(int n, int[] cuts) {
         Arrays.sort(cuts);
        int l=cuts.length+2;
        int arr[]= new int[l];
        int len= cuts.length;
        int dp[][]= new int[l][l];
        for(int i=0;i<l;i++)
        Arrays.fill(dp[i],-1);
        arr[0]=0;
        arr[l-1]=n;
        for(int k=1;k<l-1;k++)
        {
            arr[k]=cuts[k-1];
        }
       
        
        return cost(1,l-2,arr,dp);
        
    }
    public int cost(int i,int j,int arr[],int dp[][])
    {
        int min=Integer.MAX_VALUE;
        if(i>j)
        return 0;
        if(dp[i][j]!=-1)
        return dp[i][j];
        int c=0;
        for(int k=i;k<=j;k++)
        {
            c=arr[j+1]-arr[i-1]+cost(i,k-1,arr,dp)+cost(k+1,j,arr,dp);
            min=Math.min(min,c);
        }
        return dp[i][j]= min;
    }
}