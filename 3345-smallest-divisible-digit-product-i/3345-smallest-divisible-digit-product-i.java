class Solution {
    public int smallestNumber(int n, int t) {
        
        while(pro(n)%t!=0)
        {
            n++;
        }
        return n;
    }
    public int pro(int n)
    {
        int pro=1;
        while(n>0)
        {
            pro*= n%10;
            n/=10;
        }
        return pro;
    }
    
}