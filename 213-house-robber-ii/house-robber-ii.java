class Solution {
    public int rob(int[] nums) {
        if(nums.length==1)
        return nums[0];
        int rob1[]= new int[nums.length];
        int rob2[]= new int[nums.length];
        Arrays.fill(rob1,-1);
        Arrays.fill(rob2,-1);
        int ans1= fun(rob1,nums,0,nums.length-2);
        int ans2=fun(rob2,nums,1,nums.length-1);
        return Math.max(ans1,ans2);
    }
    public int fun(int arr[],int nums[],int start,int end)
    {
        
        if(end<start)
        return 0;
        if(arr[end]!=-1)
        return arr[end];
        if(start==end)
        return nums[start];
        int pick=nums[end]+fun(arr,nums,start,end-2);
        int not= fun(arr,nums,start,end-1);
        return arr[end]= Math.max(pick,not);
    }
}