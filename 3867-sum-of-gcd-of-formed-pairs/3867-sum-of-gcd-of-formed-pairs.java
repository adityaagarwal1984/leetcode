class Solution {
    public long gcdSum(int[] nums) {
        int max[]= new int[nums.length];
        max[0]= nums[0];
        for(int i=1;i<nums.length;i++)
        {
            max[i]= Math.max(max[i-1],nums[i]);
        }
        int prefix[]= new int[nums.length];
        for(int i=0;i<nums.length;i++)
        {
            prefix[i]= gcd(nums[i], max[i]);
        }
        Arrays.sort(prefix);
        long ans=0;
        int i=0;int j= nums.length-1;
        while(i<j)
        {
            int g= gcd(prefix[i],prefix[j]);
            ans+=g;
            i++;
            j--;
        }
        return ans;
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