class Solution {
    public int candy(int[] ratings) {
        int arr[]= new int[ratings.length];
        arr[0]=1;
        int n=arr.length;
        for(int i=1;i<arr.length;i++)
        {
            if(ratings[i]>ratings[i-1])
            arr[i]=arr[i-1]+1;
            else
            arr[i]=1;
        }
        for(int j=n-2;j>=0;j--)
        {
            if(ratings[j]>ratings[j+1])
            arr[j]=Math.max(arr[j],arr[j+1]+1);
            
        }
        int c=0;
        for(int num:arr)
        {
            c+=num;
        }
        return c;
        
    }
}