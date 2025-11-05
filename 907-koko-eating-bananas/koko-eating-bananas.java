class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        if(piles.length>h)
        return -1;
        int lb=1;
        int max=Integer.MIN_VALUE;
        for(int num:piles)
        max=Math.max(max,num);
        int ub=max;
        int ans=-1;
        while(lb<=ub)
        {
            int mid=lb+(ub-lb)/2;
            if(caneat(piles,h,mid))
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
    public boolean caneat(int arr[],int hrs,int speed)
    {
        int hours=0;
        for(int num:arr)
        {
            if(num%speed==0)
            hours+=num/speed;
            else
            hours+=(num/speed)+1;
            if(hours>hrs)
            return false;
        }
        if(hours<=hrs)
        return true;
        else
        return false;
    }
}