import java.util.*;

class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        int[][] memo = new int[n][m];  // -1 not computed, 0 false, 1 true
        for (int[] row : memo) Arrays.fill(row, -1);

        return match(s, p, n - 1, m - 1, memo);
    }

    private boolean match(String s, String p, int i, int j, int[][] memo) {
        // base cases
        if (i < 0 && j < 0) return true;
        if (i < 0 && j >= 0) {
            for (int k = 0; k <= j; k++) {
                if (p.charAt(k) != '*') return false;
            }
            return true;
        }
        if (i >= 0 && j < 0) return false;

        // already computed
        if (memo[i][j] != -1) return memo[i][j] == 1;

        boolean ans;
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
            ans = match(s, p, i - 1, j - 1, memo);
        } else if (p.charAt(j) == '*') {
            ans = match(s, p, i - 1, j, memo) || match(s, p, i, j - 1, memo);
        } else {
            ans = false;
        }

        memo[i][j] = ans ? 1 : 0;
        return ans;
    }
}
