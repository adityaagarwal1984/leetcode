/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || root==p || root==q)
        return root;
        TreeNode left= lowestCommonAncestor(root.left,p,q);
                TreeNode right= lowestCommonAncestor(root.right,p,q);
                if(left==null)
                return right;
                else if(right==null)
                return left;
                else
                return root;


    }
}
//         ArrayList<Integer> list1= new ArrayList<>();
//         ArrayList<Integer> list2= new ArrayList<>();
//         path(list1,root,p.val);
//         path(list2,root,q.val);
//         int l= Math.min(list1.size(),list2.size());
//         int idx=0;
//         for(int i=0;i<l;i++)
//         {
//             if(list1.get(i)==list2.get(i))
//             idx=i;
//         }
//         return findNode(root,list1.get(idx));

        
//     }
//     public boolean path(ArrayList<Integer> list, TreeNode root,int p)
//     {
//         if(root==null)
//         return false;
//         list.add(root.val);
//         if(root.val==p)
//         return true;
        
//         if(path(list,root.left,p)|| path(list,root.right,p))
//         return true;
//         list.remove(list.size()-1);
//         return false;
//     }
//     public TreeNode findNode(TreeNode root, int val) {
//     if (root == null || root.val == val)
//         return root;

//     TreeNode leftResult = findNode(root.left, val);
//     if (leftResult != null)
//         return leftResult;

//     return findNode(root.right, val);
// }

// }