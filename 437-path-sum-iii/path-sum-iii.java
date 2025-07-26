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
    
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null)
        return 0;
        int pathfromnode=path(root,(long)targetSum);
        int left=pathSum(root.left,targetSum);
        int right= pathSum(root.right,targetSum);
        return pathfromnode+left+right;

        
    }
    public int  path(TreeNode root, long sum)
    {
        if(root==null)
        return 0;
        int count=0;
        if(root.val==sum)
        count++;
       count+= path(root.left,sum-root.val);
       count+= path(root.right,sum-root.val);
       return count;
       
        
    }
    

}