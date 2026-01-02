class Solution {
    public int numDistinct(String s, String t) {
        int m=s.length();
        int n=t.length();
        // int dp[][]= new int[m+1][n+1];
        // for(int i=0;i<=m;i++)
        // dp[i][0]=1;
        // for(int j=1;j<=n;j++)
        // dp[0][j]=0;
        int prev[]= new int[n+1];
        
        prev[0]=1;
        for(int i=1;i<=m;i++)
        {
            int dp[]= new int[n+1];
            dp[0]=1;
            
            for(int j=1;j<=n;j++)
            {
                if(s.charAt(i-1)==t.charAt(j-1))
                {
                    dp[j]=prev[j]+prev[j-1];
                }
                else
                {
                    dp[j]=prev[j];
                }
            }
            prev=dp;
        }
        return prev[n];
    }
}