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

 // 0 means no camera not covered
 //1 measn no camera and covered
 //2 means camera
class Solution {
    int sum=0;
    public int minCameraCover(TreeNode root) {
     if(helper(root)==0)
     sum++;
      return sum;
    }
    public int helper(TreeNode root)
    {
         if(root==null)
        return 1;
        int left= helper(root.left);
        int right= helper(root.right);
        if(left==0 || right==0)
        {
        sum++;
        return 2;
        }
        
        if(left==2 || right==2)
        return 1;
        return 0;
    }
}