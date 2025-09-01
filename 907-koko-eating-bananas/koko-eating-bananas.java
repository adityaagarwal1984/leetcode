import java.util.*;

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for (int x : piles) max = Math.max(max, x);

        int l = 1, u = max, ans = max;
        while (l <= u) {
            int mid = l + (u - l) / 2;
            if (canEatAll(piles, h, mid)) {
                ans = mid;
                u = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    private boolean canEatAll(int[] piles, int h, int speed) {
        long hrs = 0;
        for (int x : piles) {
            hrs += (x + (long) speed - 1) / speed; // ceil division
            if (hrs > h) return false;             // early exit
        }
        return hrs <= (long) h;
    }
}
