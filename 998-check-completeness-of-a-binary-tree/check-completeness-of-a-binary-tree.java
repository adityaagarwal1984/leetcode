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
    public boolean isCompleteTree(TreeNode root) {
        if(root==null)
        return true;
        boolean nullcame=false;
        Queue<TreeNode> que= new LinkedList<>();
        que.offer(root);
        while(!que.isEmpty())
        {
            
            int l=que.size();
            
            
            for(int i=0;i<l;i++)
            {
                TreeNode node=que.poll();
                if(node==null)
                nullcame=true;
                else
                {
                    if(nullcame)return false;
                    que.offer(node.left);
                    que.offer(node.right);
                }
            }

        }
        return true;
        
    }


}