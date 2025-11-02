class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set=new HashSet<>();
        HashSet<Integer> wet=new HashSet<>();
        
        for(int i=0;i<nums1.length;i++)
            set.add(nums1[i]);
        for(int j=0;j<nums2.length;j++)
        {
            if(set.contains(nums2[j]))
            {
                wet.add(nums2[j]);
            set.remove(nums2[j]);
            }
        }
        int[] result = new int[wet.size()];
        int index = 0;
        for (int num : wet) {
            result[index++] = num;
        }

        return result;
    }
}