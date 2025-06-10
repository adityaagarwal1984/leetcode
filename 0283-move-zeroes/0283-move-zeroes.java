class Solution {
    public void moveZeroes(int[] nums) {
        int c=0,idx=0;
        for(int num: nums)
        {
            if(num==0)
            c++;
            else
            {
                nums[idx]=num;
                idx++;
            }
        }
            for(int i=0;i<c;i++)
            {
                nums[idx++]= 0;
            }
        
        
    }
}