class Solution {
    public String longestPalindrome(String s) {
    
    int start=0,end=0;
    for(int i=0;i<s.length();i++)
    {
        int oddlen=expand(s,i,i);
        int evenlen=expand(s,i,i+1);
        int len= Math.max(oddlen,evenlen);
        if(len>end-start)
        {
            start=i-(len-1)/2;
            end=i+(len/2);
        }
    }
    return s.substring(start,end+1);
}
public int expand(String s,int left,int right)
{
    while(left>=0 && right<s.length()&& s.charAt(left)==s.charAt(right))
    {
        left--;
        right++;
    }
    return right-left-1;
}

}