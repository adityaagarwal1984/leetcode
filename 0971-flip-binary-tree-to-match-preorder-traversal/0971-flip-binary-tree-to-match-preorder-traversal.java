class Solution {
    int idx = 0;
    List<Integer> ans = new ArrayList<>();

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        ans.clear();
        idx = 0;
        if (dfs(root, voyage)) {
            return ans;
        }
        return Arrays.asList(-1);
    }

    private boolean dfs(TreeNode root, int[] voyage) {
        if (root == null) return true;

        // Base mismatch check
        if (root.val != voyage[idx]) {
            return false;
        }
        idx++;

        // If left child exists and doesn't match the next element in voyage, FLIP!
        if (root.left != null && root.left.val != voyage[idx]) {
            ans.add(root.val); // Record the node where flip occurs
            
            // Traverse right first, then left
            return dfs(root.right, voyage) && dfs(root.left, voyage);
        }

        // Standard traversal: left first, then right
        return dfs(root.left, voyage) && dfs(root.right, voyage);
    }
}