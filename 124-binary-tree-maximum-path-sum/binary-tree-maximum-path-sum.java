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
    private int maxsum=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxgain(root);
        return maxsum;
    }
    public int maxgain(TreeNode root)
    {
        if(root==null)
        return 0;

        int leftgain= Math.max(maxgain(root.left),0);
        int rightgain=Math.max(maxgain(root.right),0);
        int currsum= root.val+leftgain+rightgain;
        maxsum=Math.max(maxsum,currsum);
        return root.val+Math.max(leftgain,rightgain);
    }
}