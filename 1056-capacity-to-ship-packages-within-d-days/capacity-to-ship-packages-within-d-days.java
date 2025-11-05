class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int max=Integer.MIN_VALUE;
        int s=0;
        for(int num:weights)
        {
            max=Math.max(max,num);
            s+=num;
        }
        int lb=max;
        int ub=s;
        int ans=-1;
        while(lb<=ub)
        {
            int mid=lb+(ub-lb)/2;
            if(cansend(weights,days,mid))
            {
                ans=mid;
                ub=mid-1;
            }
            else
            lb=mid+1;
        }
        return ans;
    }
    public boolean cansend(int arr[],int days,int min)
    {
        int d=1;
        int weight=0;
        
        int i=0;
        while(i<arr.length)
        {
            if(weight+arr[i]<=min)
            {
                weight+=arr[i];
                i++;
            }
            else
            {
                weight=0;
                d++;
            }
            
        }
        return d<=days;
    }
}