class Solution {
    public int minimumPushes(String word) {
        int ans=0;
        for(int i=0;i<word.length();i++)
        {
         int div= i/8;
         ans+=div+1;
        }
        return ans;
    }
}