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
    public List<TreeNode> generateTrees(int n) {
         if(n==0)
         return new ArrayList<>();
         return build(1,n);
        
    }
    public List<TreeNode> build(int s,int e)
    {
        List<TreeNode> ans= new ArrayList<>();
        if(s>e)
        {
            ans.add(null);
            return ans;

        }
        for(int i=s;i<=e;i++)
        {
            List<TreeNode> left=build(s,i-1);
            List<TreeNode> right=build(i+1,e);
            for(TreeNode l:left)
            
            {
                for(TreeNode r:right)
                {
                    TreeNode root=new TreeNode(i);
                    root.left=l;
                    root.right=r;
                    ans.add(root);
                }
            }

        }
        return ans;
    }
}