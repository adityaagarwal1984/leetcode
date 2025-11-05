
class Solution {
    public boolean search(int[] nums, int target) {
        int lb=0;
        int ub=nums.length-1;
        while(lb<=ub)
        {
            int mid=lb+(ub-lb)/2;
            if(nums[mid]==target)
            return true;
            if(nums[lb]==nums[mid] && nums[mid]==nums[ub]){
            lb++;
            ub--;
            }
           else if(nums[lb]<=nums[mid])
            {
                if(target>=nums[lb] && target<nums[mid])
                ub=mid-1;
                else
                lb=mid+1;
            }
            else
            {
                if(target>nums[mid] && target<=nums[ub])
                {
                    lb=mid+1;

                }
                else
                ub=mid-1;
            }
        }
        return false;
        
    }
}