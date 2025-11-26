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
    int idx;
    pair(TreeNode node,int i)
    {
        this.node=node;
        this.idx=i;
    }

 }
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<pair> que= new LinkedList<>();
        que.offer(new pair(root,0));
        int ans=0;
        if(root==null)
        return 0;
        // int id=1;
        while(!que.isEmpty())
        {
            int l= que.size();
            List<pair> list= new ArrayList<>();
            for(int i=0;i<l;i++)
            {
                pair del= que.poll();
                list.add(del);
                TreeNode n=del.node;
                int id=del.idx;
               

               if(n.left!=null)
                {
                    que.offer(new pair(n.left,2*id+1));
                }
                
                
               if(n.right!=null)
                {
                    que.offer(new pair(n.right,2*id+2));
                }
                
                
            }
            int size=list.get(list.size()-1).idx-list.get(0).idx+1;
            ans=Math.max(ans,size);


        }
        return ans;

        
    }
}