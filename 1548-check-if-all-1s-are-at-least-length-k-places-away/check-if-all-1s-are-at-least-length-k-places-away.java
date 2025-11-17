class Solution {
    public boolean kLengthApart(int[] nums, int K) {

        int i=0;
        int j=-1;int k=-1;
        while(i<nums.length)
        {
         if(nums[i]==1)
         {
            if(j==-1)
            j=i;
            else
            {
                k=i;
                if(k-j<K+1)
                return false;
                j=i;
            }
         } 
         i++;

        }
        return true;
        
    }
}