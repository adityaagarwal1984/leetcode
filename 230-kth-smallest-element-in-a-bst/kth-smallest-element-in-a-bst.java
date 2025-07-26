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
class Solution{
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list= new ArrayList<>();
        inorder(root,list);
        return list.get(k-1);
        
    }
    public void inorder(TreeNode root, List<Integer> list)
    {
        if(root==null)
        return;
        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
    }
}
// class Solution{
// public int kthSmallest(TreeNode root, int k) {
//     int count = 0;
//     TreeNode curr = root;

//     while (curr != null) {
//         if (curr.left == null) {
//             count++;
//             if (count == k) return curr.val;
//             curr = curr.right;
//         } else {
//             TreeNode pred = curr.left;
//             while (pred.right != null && pred.right != curr) {
//                 pred = pred.right;
//             }

//             if (pred.right == null) {
//                 pred.right = curr;
//                 curr = curr.left;
//             } else {
//                 pred.right = null;
//                 count++;
//                 if (count == k) return curr.val;
//                 curr = curr.right;
//             }
//         }
//     }

//     return -1; // in case k is invalid
// }
// }
