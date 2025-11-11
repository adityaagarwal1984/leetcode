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
        List<List<Integer>> list= new ArrayList<>();
        if(root==null)
        return list;
        Queue<TreeNode> que= new LinkedList<>();
        que.offer(root);
        while(!que.isEmpty())
        {
            int l= que.size();
            List<Integer> slist= new ArrayList<>();
            for(int i=0;i<l;i++)
            {
                TreeNode node= que.poll();
                if(node.left!=null)
                que.offer(node.left);
                if(node.right!=null)
                que.offer(node.right);
                slist.add(node.val);
            }
            list.add(new ArrayList<>(slist));
        }
        return list;
    }
}