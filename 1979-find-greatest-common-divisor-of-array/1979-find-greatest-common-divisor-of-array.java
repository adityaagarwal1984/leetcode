class Solution {
    public int findGCD(int[] nums) {
        int max=0;
        int min=1001;
        for(int num: nums)
        {
            max= Math.max(max,num);
            min= Math.min(min,num);
        }
        return gcd(min,max);
    }
    public int gcd(int a,int b)
    {
        while(b!=0)
        {
            int temp= b;
            b= a%b;
            a= temp;
        }
        return a;
    }
}