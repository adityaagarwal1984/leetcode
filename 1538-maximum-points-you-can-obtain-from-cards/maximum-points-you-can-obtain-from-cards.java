class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n=cardPoints.length;
        int subsize=n-k;
        int s=sum(cardPoints,subsize);
        int total=0;
        for(int num:cardPoints)
        total+=num;
        return total-s;
    }
    public int sum(int arr[],int size)
    {
        int min=Integer.MAX_VALUE;
        int l=0;
        int r=0;
        int s=0;
        while(r-l<size)
        {
            s+=arr[r];
            r++;
        }
        min=Math.min(min,s);
        while(r<arr.length)
        {
            s-=arr[l];
            l++;
            s+=arr[r];
            min=Math.min(min,s);
            r++;
        }
        return min;
    }
}