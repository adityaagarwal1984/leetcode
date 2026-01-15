class Solution {
    public boolean isMatch(String s, String p) {
        return solve(s, p, 0, 0);
    }

    private boolean solve(String s, String p, int i, int j) {
        // when pattern consumed
        if (j == p.length()) return i == s.length();

        // check if next is '*'
        boolean nextStar = (j + 1 < p.length() && p.charAt(j + 1) == '*');

        if (nextStar) {
            // option 1: treat x* as matching 0 chars → skip x*
            if (solve(s, p, i, j + 2)) return true;

            // option 2: match one char if possible → consume one
            if (i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')) {
                return solve(s, p, i + 1, j);
            }

            // nothing matches
            return false;
        } else {
            // normal match
            if (i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')) {
                return solve(s, p, i + 1, j + 1);
            }
            return false;
        }
    }
}
