class Solution {
    public int[] getNoZeroIntegers(int n) {
    
        for(int i=1;i<=n-1;i++)
        {
            int an=n-i;
            if(check(i)==false && check(an)==false)
            return new int[]{i,an};
            
        }
        return new int[]{-1,-1};
        
        
    }
    public boolean check(int n)
    {
        boolean present=false;
        while(n>0)
        {
            int d=n%10;
            if(d==0)
            return true;
            n=n/10;
        }
        return false;
    }
}