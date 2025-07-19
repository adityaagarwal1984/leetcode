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
 
    public int maxDepth(TreeNode root)
    {
      
        // if(root==null)
        // return 0;
        // Queue<TreeNode> que= new LinkedList<>();
        //  int c=0;
        // que.offer(root);
        // while(!que.isEmpty())
        // {
        //     int len=que.size();
        //     for(int i=0;i<len;i++)
        //     {
        //         if(que.peek().left!=null)
        //         que.offer(que.peek().left);
        //         if(que.peek().right!=null)
        //         que.offer(que.peek().right);
        //         que.poll();
        //     }
        //     c++;
        // }
        // return c;
        if(root==null)
        return 0;

        int left= maxDepth(root.left);
        int right=maxDepth(root.right);
        return Math.max(left,right)+1;
    }
}