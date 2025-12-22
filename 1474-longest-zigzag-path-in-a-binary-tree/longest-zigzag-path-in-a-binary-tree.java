/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int ans=0;
    public int longestZigZag(TreeNode root) {
    
        dfs(root);
        return ans;
    }
    public int[] dfs(TreeNode root)
    {
        if(root==null)
        return new int[]{-1,-1};
        int left[]=dfs(root.left);
        int right[]=dfs(root.right);
        int leftlen=left[1]+1;
        int rightlen=right[0]+1;
        ans=Math.max(ans,Math.max(leftlen,rightlen));
        return new int[]{leftlen,rightlen};
    }
}