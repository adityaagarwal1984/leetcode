class Solution {
    public int longestOnes(int[] nums, int k) {
        int zero=0;int i=0,j=0;int max=0;
        while(j<nums.length)
        {
            if(nums[j]==0)
            zero++;
            if(zero>k)
            {
                if(nums[i]==0)
                zero--;
                i++;
            }
            if(zero<=k)
            {
                int len= j-i+1;
                max=Math.max(max,len);
            }
            j++;

        }
        return max;

        
    }
}