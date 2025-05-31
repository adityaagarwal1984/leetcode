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
class Solution
 {
    public List<Integer> preorderTraversal(TreeNode root)
     {
    //      List<Integer> list= new ArrayList<>();
    //      if(root==null)
    //      return list;
    //      preorder(root,list);
    //      return list;           
    // }
        
    // public void preorder(TreeNode root,List<Integer> list)
    // {
    //     // if(root==null)
    //     // return;
    //     // list.add(root.val);
    //     // preorder(root.left,list);
    //     // preorder(root.right,list);
    //     Stack<TreeNode> st= new Stack<>();
    //     st.push(root);
    //     while(!st.isEmpty())
    //     {
    //         TreeNode node=st.pop();
    //         list.add(node.val);
    //         if(node.right!=null)
    //         st.push(node.right);
    //         if(node.left!=null)
    //         st.push(node.left);
    //     }
        
List<Integer> list= new ArrayList<>();
TreeNode cur= root;
while(cur!=null)
{
    if(cur.left==null)
    {
        list.add(cur.val);
        cur=cur.right;
    }
    else
    {
        TreeNode temp= cur.left;
        while(temp.right!=null && temp.right!=cur)
        {
            temp=temp.right;
        }
        if(temp.right==null)
        {
            temp.right=cur;
            list.add(cur.val);
            cur=cur.left;
        }
        else
        {
            temp.right=null;
            cur=cur.right;
        }
       
    }
}
 return list;
     }
 }