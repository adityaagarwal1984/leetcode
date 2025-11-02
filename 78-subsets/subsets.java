class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list= new ArrayList<>();
        int n= nums.length;
        for(int i=0;i<(1<<n);i++)
        {
            List<Integer> slist= new ArrayList<>();
            for(int j=0;j<n;j++)
            {
                if((i & (1<<j))>0)
                slist.add(nums[j]);
            }
            list.add(new ArrayList<>(slist));
        }
        return list;
        

        
    }
}