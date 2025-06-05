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
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root=null;
        for(int i=0;i<preorder.length;i++)
        {
            root= build(root,preorder[i]);
        }
        return root;
        
    }
    public TreeNode build(TreeNode root,int val)
    {
        if(root==null)
        {
            root= new TreeNode(val);
            return root;
        }
        if(root.val<val)
        {
            root.right= build(root.right,val);
        }
        if(root.val>val)
        {
            root.left= build(root.left,val);
        }
        return root;
    }
}