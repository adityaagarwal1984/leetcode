class Solution {
    public int splitArray(int[] nums, int k) {

        int max=Integer.MIN_VALUE;
        int s=0;
        for(int num:nums)
        {
            s+=num;
            max=Math.max(max,num);
        }
        int lb=max;
        int ub=s;
        int ans=-1;
        while(lb<=ub)
        {
            int mid=lb+(ub-lb)/2;
            if(canbreak(nums,k,mid))
            {
                ans=mid;
                ub=mid-1;
            }
            else
            {
                lb=mid+1;
            }
        }
        return ans;
    }
    public boolean canbreak(int arr[],int k,int sum)
    {
        int c=1;
        int currsum=0;
        for(int num:arr)
        {
            if(currsum+num<=sum)
            {
                currsum+=num;
            }
            else
            {
                c++;
                currsum=num;
            }
        }
        return c<=k;
    }
}