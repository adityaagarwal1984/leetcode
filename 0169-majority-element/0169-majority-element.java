class Solution {
    public int majorityElement(int[] nums) {
        // Arrays.sort(nums);
        // int len= nums.length;
        // return nums[len/2];
        int ans=0;int freq=0;
        for(int i=0;i<nums.length;i++)
        {
            if(freq==0)
            ans=nums[i];
            if(nums[i]==ans)
            freq++;
            else
            freq--;
        }
        return ans;
    }
}