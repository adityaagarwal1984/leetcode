/**
 * LeetCode 1277. Count Square Submatrices with All Ones
 * 
 * Approach:
 * - Use Dynamic Programming (DP).
 * - dp[i][j] = size of largest square ending at (i, j).
 * - Transition:
 *      if matrix[i][j] == 1:
 *          dp[i][j] = 1 + min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1])
 *      else:
 *          dp[i][j] = 0
 * - Final answer = sum of all dp[i][j].
 * 
 * Time Complexity: O(m * n)
 * Space Complexity: O(m * n) (can be optimized to O(n))
 */

class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;       // number of rows
        int n = matrix[0].length;    // number of cols

        int[][] dp = new int[m][n];
        int totalSquares = 0;

        // Fill DP table
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    if (i == 0 || j == 0) {
                        // First row or first column -> only 1x1 square possible
                        dp[i][j] = 1;
                    } else {
                        // Extend the minimum square from top, left, and top-left
                        dp[i][j] = 1 + Math.min(
                                        Math.min(dp[i - 1][j], dp[i][j - 1]),
                                        dp[i - 1][j - 1]
                                    );
                    }
                    // Add to total count
                    totalSquares += dp[i][j];
                }
            }
        }

        return totalSquares;
    }
}
