class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int maxlen=Integer.MIN_VALUE;
        Set<String> set= new HashSet<>();
        for(String st:wordDict)
        {
            set.add(st);
            int len=st.length();
            maxlen=Math.max(maxlen,len);

        }
        

        boolean dp[]= new boolean[s.length()+1];
        dp[0]=true;
        for(int i=1;i<=s.length();i++)
        {
            for(int j=i-1;j>=0 && i-j <=maxlen;j--)
            {
                if(dp[j] && set.contains(s.substring(j,i))){
                dp[i]=true;
                break;
                }
            }
        }
    return dp[s.length()];
    }
}