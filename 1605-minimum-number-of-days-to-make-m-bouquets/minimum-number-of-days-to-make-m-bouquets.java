class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        // total flowers needed must be ≤ available flowers
        if ((long) m * k > bloomDay.length) return -1;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int day : bloomDay) {
            min = Math.min(min, day);
            max = Math.max(max, day);
        }

        int lb = min;
        int ub = max;
        int ans = -1;

        while (lb <= ub) {
            int mid = lb + (ub - lb) / 2;

            if (canMake(bloomDay, m, k, mid)) {
                ans = mid;
                ub = mid - 1;  // try smaller day
            } else {
                lb = mid + 1;  // need more days
            }
        }

        return ans;
    }

    // Helper: check if we can make m bouquets by day 'mid'
    private boolean canMake(int[] arr, int m, int k, int day) {
        int bouquets = 0;
        int flowers = 0;

        for (int bloom : arr) {
            if (bloom <= day) {
                flowers++;
                if (flowers == k) { // one bouquet done
                    bouquets++;
                    flowers = 0;
                }
            } else {
                flowers = 0; // break sequence
            }

            if (bouquets >= m) return true; // early stop
        }

        return false;
    }
}
