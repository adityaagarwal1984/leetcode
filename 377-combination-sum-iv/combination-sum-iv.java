class Solution {
    public int combinationSum4(int[] nums, int target) {
        Integer[][] dp = new Integer[nums.length + 1][target + 1];
        return solve(nums, target, 0, dp);
    }

    public int solve(int[] arr, int tar, int i, Integer[][] dp) {
        // Base Case
        if (tar == 0)
            return 1;
        if (i == arr.length)
            return 0;

        if (dp[i][tar] != null)
            return dp[i][tar];

        int take = 0;

        // We can take arr[i] if it's <= target, and restart from index 0
        if (arr[i] <= tar)
            take = solve(arr, tar - arr[i], 0, dp);

        // Move to next element
        int notTake = solve(arr, tar, i + 1, dp);

        dp[i][tar] = take + notTake;
        return dp[i][tar];
    }
}
