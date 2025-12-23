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
    int maxdepth=-1;
    int ans=0;
    public int findBottomLeftValue(TreeNode root) {
        find(root,0);
        return ans;
    }
    public void find(TreeNode node,int depth)
    {
        if(node==null)
        return;
        if(depth>maxdepth)
        {
            maxdepth=depth;
            ans=node.val;
        }
        find(node.left,depth+1);
        find(node.right,depth+1);
    }
}