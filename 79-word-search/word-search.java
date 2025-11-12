class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (containsWord(i, j, board, 0, word))
                        return true;
                }
            }
        }
        return false;
    }

    public boolean containsWord(int i, int j, char[][] arr, int idx, String word) {
        // Base case: word found
        if (idx == word.length())
            return true;

        // Out of bounds or mismatch
        if (i < 0 || i >= arr.length || j < 0 || j >= arr[0].length || arr[i][j] != word.charAt(idx))
            return false;

        char ch = arr[i][j];
        arr[i][j] = '#'; // mark visited

        // Explore all directions
        boolean found = containsWord(i + 1, j, arr, idx + 1, word)
                     || containsWord(i - 1, j, arr, idx + 1, word)
                     || containsWord(i, j + 1, arr, idx + 1, word)
                     || containsWord(i, j - 1, arr, idx + 1, word);

        arr[i][j] = ch; // backtrack
        return found;
    }
}
