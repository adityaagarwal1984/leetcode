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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> que= new LinkedList<>();
        que.offer(root);
        int level=0;
        int max=1;
        int s=root.val;
        while(!que.isEmpty())
        {
            int sum=0;
            List<Integer> ls= new ArrayList<>();
            int l= que.size();
            level++;
            for(int  i=0;i<l;i++)
            {
                TreeNode node=que.poll();
                if(node.left!=null)
                que.offer(node.left);
                if(node.right!=null)
                que.offer(node.right);
                ls.add(node.val);

            }
            for(int num:ls)
            sum+=num;
            if(sum>s)
            {
                s=sum;
                max=level;
            }
        }
        return max;
    }
}