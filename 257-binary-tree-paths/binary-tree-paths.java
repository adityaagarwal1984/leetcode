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
    public List<String> binaryTreePaths(TreeNode root) {
        List<List<Integer>> ans= new ArrayList<>();
        List<Integer> ls= new ArrayList<>();
        helper(root,ans,ls);
        List<String> aaa= new ArrayList<>();
        for(List<Integer> a: ans)
        {
             StringBuilder sb= new StringBuilder();
            for(int i=0;i<a.size();i++)
            {
               
                if(i!=a.size()-1)
                sb.append(a.get(i)+"->");
                else
                sb.append(a.get(i));

            }
            String s= sb.toString();
            aaa.add(s);
        }
        return aaa;
    }
    public void helper(TreeNode root, List<List<Integer>> ans,List<Integer> ls)
    {
        if(root==null)
        return;
        ls.add(root.val);
        if(root.left==null && root.right==null)
        ans.add(new ArrayList<>(ls));

        helper(root.left,ans,ls);
        helper(root.right,ans,ls);
        ls.remove(ls.size()-1);
    }
}