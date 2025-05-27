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
    public List<Integer> rightSideView(TreeNode root) {
        
     
     List<Integer> slist= new ArrayList<>();
     if(root==null)
     return slist;   
     Queue<TreeNode> que= new LinkedList<>();
     que.offer(root);
     solve(slist,que);
     return slist;
    }
    public void solve(List<Integer> slist,Queue<TreeNode> que)
    {
        while(!que.isEmpty())
        {
            List<Integer> list= new ArrayList<>();
            int l=que.size();
            for(int i=0;i<l;i++)
            {
                TreeNode node=que.poll();
                list.add(node.val);
                if(node.left!=null)
                que.offer(node.left);
                if(node.right!=null)
                que.offer(node.right);
            }
            int data= list.get(list.size()-1);
            slist.add(data);
        }
    }
}