class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        long arr[]= new long[prices.length];
        long sum[]= new long[prices.length];
        long c=0;
        for(int i=0;i<prices.length;i++)
        {
            c+=strategy[i]*prices[i];
            arr[i]=c;
        }
        long c1=0;
        for(int i=0;i<prices.length;i++)
        {
            c1+=prices[i];
            sum[i]=c1;
        }
        long max=c;
        int i=0;
        int j=k-1;
        int mid=(j-i)/2;
        
       long s=arr[sum.length-1]-arr[j]+(sum[j]-sum[mid]);
       max=Math.max(max,s);

       j++;
       i++;
        while(j<prices.length)
        {
             mid=i+(j-i)/2;
             s=(arr[sum.length-1]-(arr[j]-arr[i-1]))+(sum[j]-sum[mid]);
             max=Math.max(max,s);
            j++;
            i++;
        }
        
        return max;

    }
}