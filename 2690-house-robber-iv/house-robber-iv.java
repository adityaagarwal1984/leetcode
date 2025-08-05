class Solution {
    public boolean canRob(int[] nums, int mid, int k) {
        int count = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= mid) {
                count++;
                i++;
            }
        }
        return count >= k;
    }

    public int minCapability(int[] nums, int k) {
        int max= Integer.MIN_VALUE;
        for(int num:nums)
        max=Math.max(max,num);
        int left = 1, right = max, ans = right;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (canRob(nums, mid, k)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}