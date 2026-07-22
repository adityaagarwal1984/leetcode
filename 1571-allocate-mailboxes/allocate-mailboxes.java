class Solution {
    public int minDistance(int[] houses, int k) {
        int n= houses.length;
        Arrays.sort(houses);
        int dp[][]= new int[n+1][k+1];
        for(int i=0;i<n;i++)
        {
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        for(int i=0;i<n;i++)
        {
            for(int shop=i;shop<=k;shop++)
            {
                dp[i][shop]=0;
            }
        }
        //dp[0][0]=0;
        for(int i=1;i<=n;i++)
        {
            for(int shop=1;shop<=Math.min(i,k);shop++)
            {
                int min= Integer.MAX_VALUE;
                for(int j=i;j>=1;j--)
                {
                    int sum= sum(j-1,i-1,houses);
                    if(dp[j-1][shop-1]!=Integer.MAX_VALUE)
                    min= Math.min(min, sum+dp[j-1][shop-1]);
                }
                dp[i][shop]= min;
            }
        }
       return dp[n][k];
    }
    public int sum(int i,int j,int arr[])
    {
        int len= j-i+1;
        int idx= len/2;
        int val= arr[i+idx];
        int s=0;
        for(int x=i;x<=j;x++)
        {
            s+= Math.abs(arr[x]-val);

        }
        return s;

    }
}