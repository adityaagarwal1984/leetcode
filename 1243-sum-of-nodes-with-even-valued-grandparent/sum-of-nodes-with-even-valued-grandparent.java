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
    public int sumEvenGrandparent(TreeNode root) {
        int sum=0;
        Set<TreeNode> set= new HashSet<>();
        helper(root,set);
        for(TreeNode num:set)
        {
            if(num !=null)
            {
                if(num.left!=null)
                sum+=num.left.val;
                if(num.right!=null)
                sum+=num.right.val;
            }
        }
        return sum;
        
    }
    public void helper(TreeNode root,Set<TreeNode> set)
    {
        if(root==null)
        return;
        if(root.val%2==0)
        {
            set.add(root.left);
            set.add(root.right);
        }
        helper(root.left,set);
        helper(root.right,set);
    }

}