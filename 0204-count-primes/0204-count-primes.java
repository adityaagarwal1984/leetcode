class Solution {
    public int countPrimes(int n) {
        if(n<=2)
        return 0;
        int isprime[]= new int[n];
        Arrays.fill(isprime,1);
        isprime[0]=0;isprime[1]=0;
        
        for(int i=2;i*i<n;i++)
        {
            if(isprime[i]==1)
            {
                for(int j=i*i ;j<n;j=j+i)
                {
                    isprime[j]=0;
                }
            }
        }
        int c=0;
        for(int i=0;i<isprime.length;i++)
        {
            if(isprime[i]==1)
            c++;
        }
        return c;
        
    }
}