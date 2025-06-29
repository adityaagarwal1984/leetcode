class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        
        return atmostk(nums,k)- atmostk(nums,k-1);
        
    }
    public int atmostk(int arr[],int k)
    {
        int l=0,r=0,count=0,c=0;
        while(r<arr.length)
        {
            if((arr[r] & 1)==1)
            c++;
            while(c>k)
            {
                if((arr[l] & 1)==1)
                c--;
                l++;
            }
            count+=r-l+1;
            r++;
            
        }
        return count;
    }
}