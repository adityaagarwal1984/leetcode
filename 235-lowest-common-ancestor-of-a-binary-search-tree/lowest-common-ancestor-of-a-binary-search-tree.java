/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==p || root==q || root==null)
        return root;
        if((root.left==p && root.right==q)||(root.left==q && root.right==p))
        return root;
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q); 
        if(left==null)
        return right;
        else if(right==null)
        return left;
        else
        return root;
    //     if(root==null || root==p || root==q)
    //     return root;
    //     int cur= root.val;
    //     if(cur>p.val && cur>q.val)
    //    return lowestCommonAncestor(root.left,p,q);
    //     if(cur<p.val && cur<q.val)
    //    return  lowestCommonAncestor(root.right,p,q);


    //     return root;

        
    }
}