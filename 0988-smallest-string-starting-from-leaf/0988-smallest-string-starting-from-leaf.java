class Solution {
    public String smallestFromLeaf(TreeNode root) {
        return dfs(root, new StringBuilder());
    }

    private String dfs(TreeNode node, StringBuilder sb) {
        if (node == null) return null;

        
        sb.insert(0, (char) (node.val + 'a'));

        
        if (node.left == null && node.right == null) {
            String leafStr = sb.toString();
            sb.deleteCharAt(0); // backtrack
            return leafStr;
        }

        String left = dfs(node.left, sb);
        String right = dfs(node.right, sb);

        // Backtrack step
        sb.deleteCharAt(0);

        // If one side is null, return the other
        if (left == null) return right;
        if (right == null) return left;

        // Compare lexicographically
        return left.compareTo(right) < 0 ? left : right;
    }
}
