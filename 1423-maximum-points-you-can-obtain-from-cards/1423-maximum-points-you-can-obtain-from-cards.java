class Solution {
    public int maxScore(int[] cardPoints, int k) {
       int sum=0;
       int n= cardPoints.length;

       for(int i=0;i<k;i++)
       sum+=cardPoints[i];
       int max=sum;
       for(int i=1;i<=k;i++)
       {
        sum-=cardPoints[k-i];
        sum+=cardPoints[n-i];
        max=Math.max(max,sum);
       }
       return max;
    }
}