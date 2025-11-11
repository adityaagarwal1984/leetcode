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
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null)
        return 0;
        int maxi[]=new int[1];
        diameter(root,maxi);
        return maxi[0];
        
    }
    public int diameter(TreeNode root,int maxi[])
    {
        if(root==null)
        return 0;
        int left= diameter(root.left,maxi);
        int right=diameter(root.right,maxi);
        maxi[0]=Math.max(maxi[0],left+right);
        return Math.max(left,right)+1;
    }
}