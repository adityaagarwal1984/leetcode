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
    public int sumNumbers(TreeNode root) {
        if(root==null)
        return 0;
        return sum(root,0);
        
    }
    public int sum(TreeNode root,int cur)
    {
        if(root==null)
        return 0;
        cur=cur*10+root.val;
        if(root.left==null && root.right==null)
        return cur;
        int left=sum(root.left,cur);
        int right=sum(root.right,cur);
        return left+right;
    }
}