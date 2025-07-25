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
        List<Integer> slist= new ArrayList<>();
        List<List<Integer>> list= new ArrayList<>();
        path(root,slist,list,targetSum);
        return list;
        
    }
    public void path(TreeNode root,List<Integer> slist,List<List<Integer>> list,int target)
    {
        if(root==null)
        return;
        slist.add(root.val);
        target-=root.val;
        if(root.left==null && root.right==null && target==0)
        list.add(new ArrayList<>(slist));
        else
        {
            if(root.left!=null)
            path(root.left,slist,list,target);
            if(root.right!=null)
            path(root.right,slist,list,target);
        }
        slist.remove(slist.size()-1);
    }
}