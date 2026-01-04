class Solution {
    public int findMaxVal(int n, int[][] restrictions, int[] diff) {

        long INF = (long) 1e18;
        long[] upper = new long[n];

        // 1️⃣ initialize upper bounds
        Arrays.fill(upper, INF);
        upper[0] = 0;

        // 2️⃣ apply restrictions (as upper bounds, not fixed values)
        for (int[] r : restrictions) {
            int idx = r[0];
            int val = r[1];
            upper[idx] = Math.min(upper[idx], val);
        }

        // 3️⃣ left → right pass
        for (int i = 1; i < n; i++) {
            upper[i] = Math.min(upper[i], upper[i - 1] + diff[i - 1]);
        }

        // 4️⃣ right → left pass
        for (int i = n - 1; i > 0; i--) {
            upper[i - 1] = Math.min(upper[i - 1], upper[i] + diff[i - 1]);
        }

        // 5️⃣ find max possible value
        long ans = 0;
        for (long val : upper) {
            ans = Math.max(ans, val);
        }

        return (int) ans;
    }
}
