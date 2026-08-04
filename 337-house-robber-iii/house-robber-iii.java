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
    public int rob(TreeNode root) {
        HashMap<TreeNode,Integer> map= new HashMap<>();
        fill(map,root);
       return  solve(root,map);
    }
    public void fill(HashMap<TreeNode,Integer> map,TreeNode node)
    {
        if(node==null) return;
        map.put(node,-1);
        fill(map,node.left);
        fill(map,node.right);
    }
    public int solve(TreeNode root,HashMap<TreeNode,Integer> map)
    {
        if(root==null) return 0;
        if(map.get(root)!=-1) return map.get(root);
        int take=root.val;
        if(root.left!=null)
        {
            if(root.left.left!=null)
            {
                take+= solve(root.left.left,map);
            }
            if(root.left.right!=null)
            {
                take+= solve(root.left.right,map);
            }
        }
        if(root.right!=null)
        {
            if(root.right.left!=null)
            {
                take+= solve(root.right.left,map);
            }
            if(root.right.right!=null)
            {
                take+= solve(root.right.right,map);
            }
        }
        int nottake= 0;
        if(root.left!=null)
        {
            nottake+= solve(root.left,map);
        }
        if(root.right!=null)
        {
            nottake+= solve(root.right,map);
        }
        map.put(root,Math.max(take,nottake));
        return Math.max(take,nottake);
    }

}