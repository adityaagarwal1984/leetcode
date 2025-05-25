class Solution {
    public long minCuttingCost(int n, int m, int k) {
        // If both logs are already small enough, no need to cut
        if (n <= k && m <= k) return 0;

        long minCost = Long.MAX_VALUE;

        // Try cutting the first log
        for (int i = 1; i < n; i++) {
            int len1 = i;
            int len2 = n - i;
            // After cutting n, we now have len1, len2, and m
            if (len1 <= k && len2 <= k && m <= k) {
                long cost = (long) len1 * len2;
                minCost = Math.min(minCost, cost);
            }
        }

        // Try cutting the second log
        for (int i = 1; i < m; i++) {
            int len1 = i;
            int len2 = m - i;
            // After cutting m, we now have len1, len2, and n
            if (len1 <= k && len2 <= k && n <= k) {
                long cost = (long) len1 * len2;
                minCost = Math.min(minCost, cost);
            }
        }

        // If no valid cut found, it's not possible (per constraints, this shouldn't happen)
        return minCost == Long.MAX_VALUE ? 0 : minCost;
    }
}
