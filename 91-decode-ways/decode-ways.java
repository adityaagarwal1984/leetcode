class Solution {
    public int numDecodings(String s) {
        int dp[]= new int[s.length()];
        Arrays.fill(dp,Integer.MIN_VALUE);
       return solve(s,0,dp); 
    }
    public int solve(String s,int idx,int dp[])
    {
        if(idx==s.length())
        return 1;
        if(s.charAt(idx)=='0')
        return 0;
        if(dp[idx]!=Integer.MIN_VALUE)
        return dp[idx];
        int one=0;
        int two=0;
        //if(idx+1<s.length() && s.charAt(idx+1)-'0'>0 && s.charAt(idx+1)-'0'<=9)
        one=solve(s,idx+1,dp);
       
        if(idx+1<s.length())
        {
            int num = (s.charAt(idx) - '0') * 10 + (s.charAt(idx+1) - '0');

            if(num>=10 && num <=26)
            two=solve(s,idx+2,dp);
        }
         
        return dp[idx]=one+two;
    }
}