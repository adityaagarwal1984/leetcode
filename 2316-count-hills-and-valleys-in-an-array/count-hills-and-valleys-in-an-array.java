class Solution {
    public int countHillValley(int[] nums) {
        int hill=0;
        int valley=0;
        int i=0;
        int j=1;
        while(j<nums.length-1)
        {
            if(nums[i]<nums[j] && nums[j]> nums[j+1])
            {
                hill++;
                i=j;
                j=j+1;
                
            }
             else if(nums[i]>nums[j] && nums[j]<nums[j+1]){
            valley++;
            i=j;
            j=j+1;
             }
             else
             {
                j++;
             }
        }
        return hill+valley;
        
    }
}