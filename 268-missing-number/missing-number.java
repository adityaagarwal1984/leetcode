class Solution {
    public int missingNumber(int[] nums) {
        int s1=0;int s2=0;
        int n= nums.length;
        s1=n*(n+1)/2;
        for(int num:nums)
        s2+=num;
        return s1-s2;
        
    }
}