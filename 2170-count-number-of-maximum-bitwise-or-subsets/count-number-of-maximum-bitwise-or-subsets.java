class Solution {
    int count = 0;
    int maxOr = 0;

    public int countMaxOrSubsets(int[] nums) {
        for (int num : nums) {
            maxOr |= num;  // Step 1: find max OR
        }
        backtrack(nums, 0, 0);
        return count;
    }

    void backtrack(int[] nums, int index, int currentOr) {
        if (index == nums.length) {
            if (currentOr == maxOr) count++;
            return;
        }

        // Include nums[index]
        backtrack(nums, index + 1, currentOr | nums[index]);

        // Exclude nums[index]
        backtrack(nums, index + 1, currentOr);
    }
}
