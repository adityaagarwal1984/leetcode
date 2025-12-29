class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int dp[][]=new int[n][n];
        for(int i=0;i<n;i++)
        Arrays.fill(dp[i],Integer.MAX_VALUE);
        return minpathsum(triangle,0,0,0,dp);
        
    }
    public int minpathsum(List<List<Integer>> ls,int i,int j,int sum,int dp[][])
    {
        if(i==ls.size())
        return sum;
        if(dp[i][j]!=Integer.MAX_VALUE)
        return dp[i][j];
        int one=ls.get(i).get(j)+minpathsum(ls,i+1,j,sum,dp);
        int two=ls.get(i).get(j)+minpathsum(ls,i+1,j+1,sum,dp);
        return dp[i][j]= Math.min(one,two);


    }
}