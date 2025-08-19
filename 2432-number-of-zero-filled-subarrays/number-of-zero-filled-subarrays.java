class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long c=0;
        long zero=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==0)
            {
                zero++;
            }
            else
            {
                if(zero>0)
                {
                    long ans=zero*(zero+1)/2;
                    c+=ans;
                    zero=0;
                }
            }
        }
        if(zero>0)
                {
                    long ans=zero*(zero+1)/2;
                    c+=ans;
                    zero=0;
                }
                return c;

        
    }
}