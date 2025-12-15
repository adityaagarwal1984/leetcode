class Solution {
    public long getDescentPeriods(int[] prices) {
        if(prices.length==1)
        return 1;
    long c=0;
    int i=0;int j=1;
    while(j<prices.length)
    {
        while(j<prices.length && prices[j-1]-prices[j]==1)
        {
            j++;
        }
        int n=j-i;
        c+=(long)n*(n+1)/2;
        i=j;
        j++;
        
    }
    if(i==prices.length-1)
    c++;

    return c;
        
    }
}