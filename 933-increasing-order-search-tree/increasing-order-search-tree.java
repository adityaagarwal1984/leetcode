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
    TreeNode curr;
    public TreeNode increasingBST(TreeNode root) {
        TreeNode dum= new TreeNode(0);
        curr=dum;
        inorder(root);
        return dum.right;
        
    }
    public void inorder(TreeNode root)
    {
        if(root==null)
        return;
        inorder(root.left);
        root.left=null;
        curr.right=root;
        curr=root;
        inorder(root.right);

    }
}