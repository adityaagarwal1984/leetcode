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
        List<List<Integer>> list = new ArrayList<>();
        if(root==null)
        return list;
       
        Queue<TreeNode> queue= new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty())
        {
             List<Integer> slist = new ArrayList<>();
            int l=queue.size();
            for(int i=0;i<l;i++)
            {
                if(queue.peek().left!=null)
                queue.offer(queue.peek().left);
                if(queue.peek().right!=null)
                queue.offer(queue.peek().right);
                slist.add(queue.poll().val);
            }
            list.add(new ArrayList(slist));
        }
        return list;
        
    }
}