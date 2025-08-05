class Solution {
    public int rob(int[] nums) {
        int arr[]= new int[nums.length];
        for(int i=0;i<arr.length;i++)
        {
            arr[i]=-1;
        }
        return fun(arr,nums,nums.length-1);

        
        
    }
    public int fun(int arr[],int nums[],int i)
    {
        if(i==0)
        return nums[i];
        if(i<0)
        return 0;
        if(arr[i]!=-1)
        return arr[i];
        int pick= nums[i]+fun(arr,nums,i-2);
        int not=fun(arr,nums,i-1);
        return arr[i]= Math.max(pick,not);
    }
}