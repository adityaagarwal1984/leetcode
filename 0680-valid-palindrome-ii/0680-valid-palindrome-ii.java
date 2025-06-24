class Solution {
    public boolean validPalindrome(String s) {
       int i=0;
       int j=s.length()-1;
       while(i<j)
       {
        if(s.charAt(i)!=s.charAt(j))
        {
            return ispalin(s,i+1,j)|| ispalin(s,i,j-1);
        }
        i++;
        j--;
       }
       return true;
    }
    public boolean ispalin(String s,int left,int right)
    {
        while(left<right)
        {
            if(s.charAt(left++)!=s.charAt(right--))
            return false;
        }
        return true;
    }
}