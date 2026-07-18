class Solution {
    Boolean dp[][];
    public boolean isMatch(String s, String p) {
        dp= new Boolean[s.length()+1][p.length()+1];
        boolean ans= solve(s,p,0,0);
        return ans;
    }
    public boolean solve(String s, String p, int i,int j)
    {
        if(j==p.length()) return i==s.length();
        boolean ans=false;
        if(dp[i][j]!=null) return dp[i][j];
        if(p.charAt(j)=='?')
        ans= ans|| (i<s.length() && solve(s,p,i+1,j+1));
        else if(p.charAt(j)=='*')
        {
            ans= ans|| (solve(s,p,i,j+1) || (i<s.length() && solve(s,p,i+1,j)));
        }
        else
        {
            if(i<s.length() && s.charAt(i)==p.charAt(j))
            {
                ans= ans|| solve(s,p,i+1,j+1);
            }
            else
            return dp[i][j]= false;
        }
        return dp[i][j]=ans;
    }
}