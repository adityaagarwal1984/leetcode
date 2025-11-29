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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> map= new HashMap<>();
        for(int i=0;i<inorder.length;i++)
        {
            map.put(inorder[i],i);
        }
        TreeNode root=build(inorder,0,inorder.length-1,preorder,0,preorder.length,map);
        return root;
        
    }
    public TreeNode build(int inorder[],int instart,int inend,int preorder[],int prestart,int preend,Map<Integer,Integer> map)
    {
        if(instart>inend || prestart>preend)
        return null;

        TreeNode node=new TreeNode(preorder[prestart]);
        int idx=map.get(node.val);
        int left=idx-instart;
        node.left=build(inorder,instart,idx-1,preorder,prestart+1,prestart+left,map);
        node.right=build(inorder,idx+1,inend,preorder,prestart+left+1,preend,map);
        return node;
    }
}