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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ls= new ArrayList<>();
        if(root==null)
        return ls;
        Queue<TreeNode> que= new LinkedList<>();
        que.offer(root);
        while(!que.isEmpty())
        {
            int l= que.size();
            List<Integer> sub= new ArrayList<>();
            for(int i=0;i<l;i++)
            {
                TreeNode curr= que.poll();
                sub.add(curr.val);
                if(curr.left!=null)
                {
                    que.offer(curr.left);
                }
                if(curr.right!=null)
                {
                    que.offer(curr.right);
                }
            }
            ls.add(new ArrayList<>(sub));
        }
        return ls;
    }
}