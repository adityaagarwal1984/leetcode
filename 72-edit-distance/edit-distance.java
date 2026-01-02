class Solution {
    public int minDistance(String word1, String word2) {
        int dp[][]= new int[word1.length()][word2.length()];
        for(int i=0;i<word1.length();i++)
        Arrays.fill(dp[i],Integer.MAX_VALUE);
        return calculate(word1,word2,word1.length()-1,word2.length()-1,dp);
    }
    public int calculate(String st1,String st2,int idx1,int idx2,int dp[][])
    {
        if(idx1<0)
        return idx2+1;
        if(idx2<0)
        return idx1+1;
        if(dp[idx1][idx2]!=Integer.MAX_VALUE)
        return dp[idx1][idx2];
        if(st1.charAt(idx1)==st2.charAt(idx2))
        return dp[idx1][idx2]=calculate(st1,st2,idx1-1,idx2-1,dp);
        int insert=1+calculate(st1,st2,idx1,idx2-1,dp);
        int delete=1+calculate(st1,st2,idx1-1,idx2,dp);
        int update=1+calculate(st1,st2,idx1-1,idx2-1,dp);
        return dp[idx1][idx2]=Math.min(Math.min(insert,delete),update);

    }
}