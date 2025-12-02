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
    public int longestUnivaluePath(TreeNode root) {
        helper(root);
        return ans;
        

    }
    public int helper(TreeNode root)
    {
        if( root==null)
        return 0;
        if(root.left==null && root.right==null)
        return 0;
        int l=helper(root.left);
        int r=helper(root.right);
        int left=0;
        int right=0;
        if(root.left!=null && root.left.val==root.val)
        left=l+1;
        if(root.right!=null && root.right.val==root.val)
        right=r+1;
        ans=Math.max(ans,left+right);
        return Math.max(left,right);
    }
}