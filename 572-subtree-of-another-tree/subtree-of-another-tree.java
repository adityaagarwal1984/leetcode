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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null)
        return false;
        if(subRoot==null)
        return true;
        if(issame(root,subRoot)) return true;
       boolean left= isSubtree(root.left,subRoot);
       boolean right= isSubtree(root.right,subRoot);
       return left | right;
        
    }
    public boolean issame(TreeNode a,TreeNode b)
    {
        if(a==null && b==null)
        return true;
        if(a==null || b==null || a.val!=b.val)
        return false;
        boolean left=issame(a.left,b.left);
        boolean right=issame(a.right,b.right);
        return left && right;


    }
}