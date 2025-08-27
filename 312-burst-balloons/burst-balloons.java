class Solution {
    public int maxCoins(int[] cuts) {
        
    

        //  Arrays.sort(cuts);
        int l=cuts.length+2;
        int arr[]= new int[l];
       
        int dp[][]= new int[l][l];
        for(int i=0;i<l;i++)
        Arrays.fill(dp[i],-1);
        arr[0]=1;
        arr[l-1]=1;
        for(int k=1;k<l-1;k++)
        {
            arr[k]=cuts[k-1];
        }
       
        
        return cost(1,l-2,arr,dp);
        
    }
    public int cost(int i,int j,int arr[],int dp[][])
    {
        int max=Integer.MIN_VALUE;
        if(i>j)
        return 0;
        if(dp[i][j]!=-1)
        return dp[i][j];
        int c=0;
        for(int k=i;k<=j;k++)
        {
            c=arr[j+1]*arr[i-1]*arr[k]+cost(i,k-1,arr,dp)+cost(k+1,j,arr,dp);
            max=Math.max(max,c);
        }
        return dp[i][j]= max;
    }
}