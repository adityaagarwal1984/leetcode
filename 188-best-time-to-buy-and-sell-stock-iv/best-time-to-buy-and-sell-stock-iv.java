class Solution {
    public int maxProfit(int k,int[] prices) {
        int arr[][][]= new int[prices.length][2][k+1];
        for (int i = 0; i < prices.length; i++) {
    for (int j = 0; j < 2; j++) {
        Arrays.fill(arr[i][j], -1);
    }
}

return check(prices,0,1,k,arr);
        
    }
    public int check(int arr[],int i,int buy,int cap,int a[][][])
    {
        if(i==arr.length)
        return 0;
        if(cap==0)
        return 0;
        if(a[i][buy][cap]!=-1)
        return a[i][buy][cap];
        if(buy==1)
        {
            return a[i][buy][cap]= Math.max(-arr[i]+check(arr,i+1,0,cap,a),0+check(arr,i+1,1,cap,a));
        }
        else
        {
            return a[i][buy][cap]= Math.max(arr[i]+check(arr,i+1,1,cap-1,a),check(arr,i+1,0,cap,a));

        }
    }
}