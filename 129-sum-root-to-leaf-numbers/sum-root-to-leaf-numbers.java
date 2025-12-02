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
    public int sumNumbers(TreeNode root) {
        if(root==null)
        return 0;
        int sum=0;

        List<List<Integer>> ans= new ArrayList<>();
     List<Integer> ls= new ArrayList<>();
    
     helper(root,ans,ls);
    for(List<Integer> l:ans)
    {
        int n=0;
        for(int num:l)
        {
            n=n*10+num;
        }
        sum+=n;
    }
    return sum;
        
    }
    public void helper (TreeNode root,List<List<Integer>> ans,List<Integer> ls)
    {
        if(root==null)
        return;
       ls.add(root.val);
     if(root.left==null && root.right==null)
     {
        ans.add(new ArrayList<>(ls));
     }

     if(root.left!=null)
     {
         helper(root.left,ans,ls);
     }
     if(root.right!=null)
     {
          helper(root.right,ans,ls);
     }
    ls.remove(ls.size()-1);
    }
}