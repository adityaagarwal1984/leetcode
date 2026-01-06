class Solution {
    public int maxProfit(int[] prices) {
    int arr[]= new int[prices.length];
    arr[0]=0;
    for(int i=1;i<prices.length;i++)
    {
        if(prices[i]>prices[i-1])
        arr[i]=arr[i-1]+(prices[i]-prices[i-1]);
        else
        arr[i]=arr[i-1];
    }
    return arr[prices.length-1];
    }
}