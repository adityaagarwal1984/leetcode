class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int dp[][]= new int[text1.length()+1][text2.length()+1];
        for(int i=0;i<text1.length()+1;i++)
        Arrays.fill(dp[i],Integer.MIN_VALUE);
        return length(text1,text2,text1.length()-1,text2.length()-1,dp);
    }
    public int length(String s1,String s2,int idx1,int idx2,int dp[][])
    {
        if(idx1<0 || idx2<0)
        return 0;
        if(dp[idx1][idx2]!=Integer.MIN_VALUE)
        return dp[idx1][idx2];
        if(s1.charAt(idx1)==s2.charAt(idx2))
        return 1+length(s1,s2,idx1-1,idx2-1,dp);
        return dp[idx1][idx2]=Math.max(length(s1,s2,idx1-1,idx2,dp),length(s1,s2,idx1,idx2-1,dp));
    }
}