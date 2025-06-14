class Solution {
    public int subarraySum(int[] nums, int k) {
        // int c=0;
        // for(int i=0;i<nums.length;i++)
        // {
        //     int sum=0;
        //     for(int j=i;j<nums.length;j++)
        //     {
        //         sum+=nums[j];
        //         if(sum==k)
        //         c++;
        //     }
        // }
        // return c;
        HashMap<Integer,Integer> map= new HashMap<>();
        int c=0;
        int sum=0;
        map.put(0,1);
        for(int num:nums)
        {
            sum+=num;
            if(map.containsKey(sum-k))
            c+=map.get(sum-k);

            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return c;
    }
}