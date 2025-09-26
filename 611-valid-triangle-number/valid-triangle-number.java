class Solution {
    public int triangleNumber(int[] nums) {
        int c=0;
        Arrays.sort(nums);
        for(int k=nums.length-1;k>1;k--)
        {
            int i=0;
            int j=k-1;
            while(i<j)
            {
                if(nums[i]+nums[j]>nums[k])
                {
                c+=j-i;
                j--;
                }
                else
                i++;

            }
        }
        return c;
    }
}