import java.util.*;

class Solution {
    public int minCut(String s) {
        int n = s.length();
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        return cut(0, s, dp) - 1;
    }

    public int cut(int i, String s, int dp[]) {
        if (i == s.length()) return 0;
        if (dp[i] != -1) return dp[i];
        
        int min = Integer.MAX_VALUE;
        for (int j = i; j < s.length(); j++) {
            if (isPalindrome(s, i, j)) {
                int cost = 1 + cut(j + 1, s, dp);
                min = Math.min(min, cost);
            }
        }
        return dp[i] = min;
    }

    public boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}
