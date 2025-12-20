class Solution {
    public int minDeletionSize(String[] strs) {
        int c=0;
        for(int i=0;i<strs[0].length();i++)
        {
            for(int j=0;j<strs.length-1;j++)
            {
                String s1=strs[j];
                String s2=strs[j+1];
                if(s1.charAt(i)>s2.charAt(i))
                {
                    c++;
                    break;
                }
            }
        }
        return c;
        
    }
}