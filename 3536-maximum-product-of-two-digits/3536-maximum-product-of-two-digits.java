class Solution {
    public int maxProduct(int n) {
        int one=0;
        int two=0;
        while(n>0)
        {
            int d=n%10;
            if(d>one)
            {
                two=one;
                one=d;
            }
            else
            {
                if(d>two)
                two= d;
            }
            n/=10;
        }
        return one*two;
    }
}