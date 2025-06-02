// /**
//  * Definition for a binary tree node.
//  * public class TreeNode {
//  *     int val;
//  *     TreeNode left;
//  *     TreeNode right;
//  *     TreeNode() {}
//  *     TreeNode(int val) { this.val = val; }
//  *     TreeNode(int val, TreeNode left, TreeNode right) {
//  *         this.val = val;
//  *         this.left = left;
//  *         this.right = right;
//  *     }
//  * }
//  */
// class Solution {
//     public void flatten(TreeNode root) {
//         if(root==null)
//         return;
//         List<Integer> list= new ArrayList<>();
//         preorder(root,list);
//         int len=list.size();
//         TreeNode Root=root;
//         for(int i=1;i<len;i++)
//         {
//             TreeNode node = new TreeNode(list.get(i));
//             Root.left=null;
//             Root.right=node;
//             Root=Root.right;
//         }
        
        
//     }
//     public void  preorder(TreeNode root,List<Integer> list)
//     {
//         if(root==null)
//         return;
//         list.add(root.val);
//         preorder(root.left,list);
//         preorder(root.right,list);
//     }


// }
class Solution {
    TreeNode prev=null;
        public void flatten(TreeNode root) {
            
            if(root==null)
            return ;
             flatten(root.right);
            flatten(root.left);
           
            root.right=prev;
            root.left=null;
            prev=root;
 
 
     }

}