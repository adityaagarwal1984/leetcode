class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int[] bitPos = new int[32];  // Store latest index for each bit

        for (int i = 0; i < 32; i++) {
            bitPos[i] = -1;  // initialize with -1
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int b = 0; b < 32; b++) {
                if ((nums[i] & (1 << b)) != 0) {
                    bitPos[b] = i;  // bit `b` was last seen at `i`
                }
            }

            int farthest = i;
            for (int b = 0; b < 32; b++) {
                if (bitPos[b] != -1) {
                    farthest = Math.max(farthest, bitPos[b]);
                }
            }

            ans[i] = farthest - i + 1;
        }

        return ans;
    }
}
