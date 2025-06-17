class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int ans1 = 0, ans2 = 0;
        int freq1 = 0, freq2 = 0;

        for (int i = 0; i < nums.length; i++) {
            if (freq1 == 0 && nums[i] != ans2) {
                freq1 = 1;
                ans1 = nums[i];
            } else if (freq2 == 0 && nums[i] != ans1) {
                freq2 = 1;
                ans2 = nums[i];
            } else if (nums[i] == ans1) {
                freq1++;
            } else if (nums[i] == ans2) {
                freq2++;
            } else {
                freq1--;
                freq2--;
            }
        }

        // Verify
        List<Integer> list = new ArrayList<>();
        int c1 = 0, c2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == ans1) c1++;
            else if (nums[i] == ans2) c2++; // Use else-if to avoid double count when ans1 == ans2
        }

        if (c1 > nums.length / 3) list.add(ans1);
        if (c2 > nums.length / 3) list.add(ans2);

        return list;
    }
}
