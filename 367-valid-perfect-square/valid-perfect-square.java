class Solution {
    public boolean isPerfectSquare(int num) {
        long lb=1;
        long ub=num;
        while(lb<=ub)
        {
            long mid=lb+(ub-lb)/2;
            if(mid*mid==num)
            return true;
            else if(mid*mid<num)
            lb=mid+1;
            else
            ub=mid-1;
        }
        return false;
        
    }
}