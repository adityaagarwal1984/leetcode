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
        HashMap<Integer,Integer> map= new HashMap<>();
        int n= preorder.length;
        for(int i=0;i<inorder.length;i++)
        {
            map.put(inorder[i],i);
        }
        return solve(preorder,0,n-1, inorder,0,n-1,map);
    }
    public TreeNode solve(int preorder[],int prestart,int preend,int
    inorder[], int instart,int inend,HashMap<Integer,Integer> map)
    {
        if(prestart>preend || instart>inend)
        return null;
        TreeNode node= new TreeNode(preorder[prestart]);
        int idx= map.get(preorder[prestart]);
        int left_nodes= idx-instart;
    
        node.left= solve(preorder,prestart+1,prestart+left_nodes,inorder,instart,idx,map);
        node.right= solve(preorder,prestart+left_nodes+1,preend,inorder,idx+1,inend,map);
        return node;
    }
}