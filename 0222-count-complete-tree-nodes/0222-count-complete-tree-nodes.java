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
    public int countNodes(TreeNode root) {
        if(root==null)
        return 0;
        Queue<TreeNode> que= new LinkedList<>();
        que.offer(root);
        return solve(que);
    }
    public int solve(Queue<TreeNode> que)
    {
       int c=0; 
       
       while(!que.isEmpty())
       {
        TreeNode node= que.poll();
        if(node.left!=null)
        que.offer(node.left);
            if(node.right!=null)
        que.offer(node.right);
        c++;
       }
       return c;
        
    }
    
}