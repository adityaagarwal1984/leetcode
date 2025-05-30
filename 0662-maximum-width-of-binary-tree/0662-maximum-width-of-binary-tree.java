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
 class pair
 {
    TreeNode node;
    int num;
    pair(TreeNode node,int num)
    {
        this.node=node;
        this.num=num;
    }
 }
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null)
        return 0;
        int ans=0;
        Queue<pair> que= new LinkedList<>();
        que.offer(new pair(root,0));
        while(!que.isEmpty())
        {
            int size=que.size();
            int min=que.peek().num;
            int first=0;int last=0;
            for(int i=0;i<size;i++)
            {
                int curridx= que.peek().num-min;
                TreeNode node= que.peek().node;
                que.poll();
                if(node.left!=null)
                {
                    que.offer(new pair(node.left,curridx*2+1));
                }
                if(node.right!=null)
                {
                    que.offer(new pair(node.right,curridx*2+2));
                }
                if(i==0)
                first=curridx;
                if(i==size-1)
                last=curridx;
            }
            ans=Math.max(ans,last-first+1);
        }
        return ans;


        
    }
}