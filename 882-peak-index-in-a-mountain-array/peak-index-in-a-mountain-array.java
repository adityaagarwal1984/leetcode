class Solution {
    public int peakIndexInMountainArray(int[] nums) {
          int lb=0;
        int ub=nums.length-1;
        while(lb<ub)
        {
            int mid=lb+(ub-lb)/2;
            if(nums[mid]>nums[mid+1])
            {
                ub=mid;
            }
            else
            {
                lb=mid+1;
            }
        }
        return lb;
    }
}
      
    