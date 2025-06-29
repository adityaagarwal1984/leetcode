// we will use simple maths here we will find  no of subarrays sum<=goal and at the same time we will find no of subarrays whose sum<= goal-1 subtracting both reult will give or answer. 
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal)
     {
        int a=subarray(nums,goal);
        int b= subarray(nums,goal-1);
        return a-b;

    }
    public int subarray(int nums[],int goal)
    {

    int c=0;int left=0;int right=0;
        int sum=0;
        if(goal<0)
        return 0;
        while(right< nums.length)
        {
            sum+=nums[right];
            while(sum>goal)
            {
                sum-=nums[left];
                left++;
            }
            c+= right-left+1;  // important to look it is not c++;
            right++;
        }
        return c;
        
    }
}