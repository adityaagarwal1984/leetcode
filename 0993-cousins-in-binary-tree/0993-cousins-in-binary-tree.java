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
        int childcount=0;
        
        while(!que.isEmpty())
        {
            List<Integer> list= new ArrayList<>();
            int len= que.size();
            for(int i=0;i<len;i++)
            {
                int parentcount=0;
                TreeNode node= que.poll();
                list.add(node.val);
                if(node.left!=null)
                {
                    if(node.left.val==x || node.left.val==y)
                    {
                        childcount++;
                        parentcount++;
                    }
                que.offer(node.left);
                }
                if(node.right!=null)
                {
                    if(node.right.val==x || node.right.val==y)
                    {
                        childcount++;
                        parentcount++;
                    }
                que.offer(node.right);
                }
                if(parentcount==2)
                return false;
            }
            if(childcount==2)
            return true;
            if(childcount==1)
            return false;
        }
        return false;

        
    }

}