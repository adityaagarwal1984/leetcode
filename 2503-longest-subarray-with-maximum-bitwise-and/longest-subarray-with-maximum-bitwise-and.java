class Solution {
    public int longestSubarray(int[] nums) {
        int max=0;
        for(int num:nums)
        {
            max=Math.max(max,num);
        }
        int l=0;int maxlen=0;
        for(int num:nums)
        {
            if(num==max)
            {
                l++;
                maxlen=Math.max(maxlen,l);
            }
            else
            {
                l=0;
            }
        }
        return maxlen;
    }
}