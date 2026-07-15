class Solution {
    public int gcdOfOddEvenSums(int n) {
        int odd=0;
        int even=0;
        for(int i=1;i<=2*n;i++)
        {
            if((i & 1)==1)
            odd+=i;
            else
            even+=i;
        }
        return gcd(odd,even);
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