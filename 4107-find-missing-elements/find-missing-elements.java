class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Set<Integer> set= new HashSet<>();
        int max=Integer.MIN_VALUE;
        int min= Integer.MAX_VALUE;
        for(int num: nums)
        {
            set.add(num);
            min= Math.min(min,num);
            max= Math.max(max,num);

        }
        List<Integer> ans= new ArrayList<>();
        for(int i=min;i<=max;i++)
        {
            if(!set.contains(i)) ans.add(i);
        }
        return ans;

    }
}