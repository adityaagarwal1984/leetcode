class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n1=count(nums,goal);
        int n2=count(nums,goal-1);
        return n1-n2;
        
    }
    public int count(int arr[],int sum)
    {
        int s=0;
       int c=0;
        int l=0;
        if(sum<0)
        return 0;
        for(int r=0;r<arr.length;r++)
        {
            s+=arr[r];
            while(s>sum)
            {
                
                s-=arr[l];
                l++;
            }
           
                
                c+=r-l+1;

            
            
        }
        return c;
    }
}