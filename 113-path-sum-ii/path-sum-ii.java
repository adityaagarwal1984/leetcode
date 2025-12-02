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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
     List<List<Integer>> ans= new ArrayList<>();
     List<Integer> ls= new ArrayList<>();
     if(root==null)
     return ans;
     helper(root,targetSum,ans,ls);
    return ans;

    }
    public void helper (TreeNode root,int sum,List<List<Integer>> ans,List<Integer> ls)
    {
        if(root==null)
        return;
       ls.add(root.val);
     if(root.left==null && root.right==null && root.val==sum)
     {
        ans.add(new ArrayList<>(ls));
     }

     if(root.left!=null)
     {
         helper(root.left,sum-root.val,ans,ls);
     }
     if(root.right!=null)
     {
          helper(root.right,sum-root.val,ans,ls);
     }
    ls.remove(ls.size()-1);
    }
}