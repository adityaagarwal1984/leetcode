class Solution {
    public int longestSubsequence(String s, int k) {
        int val=0;
        int c=0;
        int count=0;
        for(int i=s.length()-1;i>=0;i--)
        {
            char ch=s.charAt(i);
            if(ch=='0'){
            count++;
            c++;
            }
            else
            {
                if(c <31 && val+(1<<c) <=k)
                {
                    count++;
                    val+= 1<<c;
                    c++;              
                }
            }
        }
        return count;
    }
}