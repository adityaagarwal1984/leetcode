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
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> que= new LinkedList<>();
        que.offer(root);
        int child=0;
        while(!que.isEmpty())
        {
            int l=que.size();
            for(int i=0;i<l;i++)
            {
                int parent=0;
                TreeNode node=que.poll();
                if(node.left!=null)
                {
                    que.offer(node.left);
                 if(node.left.val==x || node.left.val==y)
                 {
                    parent++;
                    child++;
                 }   
                }
                if(node.right!=null)
                {
                    que.offer(node.right);
                 if(node.right.val==x || node.right.val==y)
                 {
                    parent++;
                    child++;
                 }   
                }
                if(parent==2)
                return false;
            }
            if(child==2)
            return true;
            if(child==1)
            return false;
        }
        return false;
    }

}