class Solution {
    public int mySqrt(int x) {
        int lb=1;
        int ub=x;
        
        while(lb<=ub)
        {
            int mid=lb+(ub-lb)/2;
            if(mid==x/mid)
            return mid;
            else if(mid<x/mid)
            {
            
            lb=mid+1;
            }
            else
            ub=mid-1;
        }
        return ub;
        
    }
}