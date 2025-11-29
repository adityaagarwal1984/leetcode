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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        
    
        Map<Integer,Integer> map= new HashMap<>();
        for(int i=0;i<postorder.length;i++)
        {
            map.put(postorder[i],i);
        }
        TreeNode root=build(preorder,0,preorder.length-1,postorder,0,postorder.length-1,map);
        return root;
        
    }
    public TreeNode build(int preorder[],int prestart,int preend,int postorder[],int poststart,int postend,Map<Integer,Integer> map)
    {
        if(prestart>preend || poststart>postend)
        return null;

        TreeNode node=new TreeNode(preorder[prestart]);
        if(prestart==preend)
        return node;
        int idx=map.get(preorder[prestart+1]);
        int left=idx-poststart+1;
        node.left=build(preorder,prestart+1,prestart+left,postorder,poststart,idx,map);
        node.right=build(preorder,prestart+left+1,preend,postorder,idx+1,postend-1,map);
        return node;
    }
}