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
    public List<Integer> inorderTraversal(TreeNode root) 
        
    {
    //      List<Integer> list= new ArrayList<>();
    //      if(root==null)
    //      return list;
    //      inorder(root,list);
    //      return list;           
    // }
        
    // public static void inorder(TreeNode root,List<Integer> list)
    // {
        
    //     Stack<TreeNode> st= new Stack<>();
    //      TreeNode node= root;
    //      while(node!=null || !st.isEmpty())
    //      {
    //         while(node!=null)
    //         {
    //             st.push(node);
    //             node=node.left;
    //         }
    //         node =st.pop();
    //         list.add(node.val);

    //         node=node.right;

        
    // }

    //=============================Morris inorder traversal==============================//

    List<Integer> list= new ArrayList<>();
    TreeNode cur=root;
    while(cur!=null)
    {
        if(cur.left==null)
        {
            list.add(cur.val);
            cur=cur.right;
        }
        else
        {
            TreeNode pre= cur.left;
            while(pre.right!=null && pre.right!=cur)
            {
                pre=pre.right;
            }
            if(pre.right==null)
            {
                pre.right=cur;
                cur=cur.left;
            }
            else
            {
                pre.right=null;
                list.add(cur.val);
                cur=cur.right;
            }
        }
    }
    return list;
    
}
}