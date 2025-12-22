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
        if(root==null)
        return 0;
        Map<TreeNode,Integer> map= new HashMap<>();
        assign(map,root);
        return robbery(root,map);
       
    }
    public int robbery(TreeNode root,Map<TreeNode,Integer> map)
    {
        if(root==null)
        return 0;
         if(map.get(root)!=Integer.MIN_VALUE)
        return map.get(root);

        int take=root.val;
        if(root.left!=null)
        take+=robbery(root.left.left,map)+robbery(root.left.right,map);
        if(root.right!=null)
        take+=robbery(root.right.right,map)+robbery(root.right.left,map);

        //nottake
        int nottake=0;
        if(root.left!=null)
        nottake+=robbery(root.left,map);
        if(root.right!=null)
        nottake+=robbery(root.right,map);

        int ans=Math.max(take,nottake);
        map.put(root,ans);
        return ans;
    }
    public void assign(Map<TreeNode,Integer> map,TreeNode root)
    {
        if(root==null)
        return;
        map.put(root,Integer.MIN_VALUE);
        assign(map,root.left);
        assign(map,root.right);
    }
}