class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        int l=words.length;
        int max=Integer.MIN_VALUE;
        int dp[]= new int[l];
        Arrays.fill(dp,1);
        for(int i=0;i<l;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(compare(words[i],words[j]) && dp[j]+1>dp[i])
                {
                    dp[i]=dp[j]+1;
                }
            }
            max=Math.max(max,dp[i]);
        }
        return max;
        
    }
    public boolean compare(String s1,String s2)
    {
        if(s1.length()!=s2.length()+1)
        return false;
        int i=0;int j=0;
        while(i<s1.length())
        {
            if( j<s2.length() && s1.charAt(i)==s2.charAt(j))
            {
                i++;
                j++;

            }
            else
            {
                i++;
            }
        }
        if( j==s2.length())
        return true;
        else
        return false;
    }
}