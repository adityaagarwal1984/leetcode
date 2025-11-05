class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long min=Integer.MAX_VALUE;
        for(int num:time)
        {
            min=Math.min(min,num);
        }
        long lb=1;
        long ub=min*totalTrips;
        long ans=-1;
        while(lb<=ub)
        {
            long mid=lb+(ub-lb)/2;
            if(cantrip(time,totalTrips,mid))
            {
                ub=mid-1;
                ans=mid;
            }
            else
            {
                lb=mid+1;
            }

        }
        return ans;
        
    }
    public boolean cantrip(int arr[],int trips,long days)
    {
        long t=0;
        for(int num:arr)
        {
            t+=days/num;
        }
        return t>=trips;

    }
}