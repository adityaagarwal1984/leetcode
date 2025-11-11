class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int maxLen = 0;
        
        for (int right = 0; right < nums.length; right++) {
            // If we encounter a zero, we use one flip
            if (nums[right] == 0) {
                k--;
            }

            // If flips exceed limit, move left pointer
            while (k < 0) {
                if (nums[left] == 0) {
                    k++;
                }
                left++;
            }

            // Update maximum window size
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
