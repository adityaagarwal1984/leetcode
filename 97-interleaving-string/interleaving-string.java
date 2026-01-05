class Solution {
    Boolean dp[][];
    public boolean isInterleave(String s1, String s2, String s3) {
      dp = new Boolean[s1.length()+1][s2.length()+1];
    
        if(s1.length()+s2.length()!=s3.length())
        return false;
        return solve(s1,s2,s3,0,0);
    }
    public boolean solve(String s1,String s2,String s3,int i1,int i2)
    {
        if(i1==s1.length() && i2==s2.length())
        return true;
        if(dp[i1][i2]!=null)
        return dp[i1][i2];
        int i3=i1+i2;
        boolean ans=false;
        if(i1<s1.length() && s3.charAt(i3)==s1.charAt(i1))
        ans=ans|| solve(s1,s2,s3,i1+1,i2);
        if(i2<s2.length() && s3.charAt(i3)==s2.charAt(i2))
        ans=ans|| solve(s1,s2,s3,i1,i2+1);
        return dp[i1][i2]=ans;
        

    }
}