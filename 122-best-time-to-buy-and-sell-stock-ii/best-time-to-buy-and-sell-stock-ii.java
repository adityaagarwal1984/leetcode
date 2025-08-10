class Solution {
    public int maxProfit(int[] prices) {
    //     int max=Integer.MIN_VALUE;
    //     int min=Integer.MAX_VALUE;
    //     int amt=0;
    //     for(int i=1;i<prices.length-1;i++)
    //     {
    //        min=Math.min(min,prices[i-1]);
    //        max=Math.max(max,prices[i]-min);
    //        if(max>0)
    //        {
    //         amt+=max;
    //         min=prices[i+1];
    //        }

    //     }
    // return amt;
    int j=0;int amt=0;
        for(int i=1;i<prices.length;i++)
        {
            if(prices[i]>prices[j])
            {
            amt+=prices[i]-prices[j];
            
            }
            j++;
        }
        return amt;
    }
}