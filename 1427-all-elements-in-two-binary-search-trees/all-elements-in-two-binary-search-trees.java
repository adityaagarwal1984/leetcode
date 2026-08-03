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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> ans1= new ArrayList<>();
        List<Integer> ans2= new ArrayList<>();
        solve(root1,ans1);
        solve(root2,ans2);
        List<Integer> ans= new ArrayList<>();
        int i=0;
        int j=0;
        while(i<ans1.size() && j<ans2.size())
        {
            if(ans1.get(i)<ans2.get(j))
            {
                ans.add(ans1.get(i));
                i++;
            }
            else
            {
                ans.add(ans2.get(j));
                j++;
            }
        }
        while(i<ans1.size())
        {
            ans.add(ans1.get(i));
            i++;
        }
        while(j<ans2.size())
        {
            ans.add(ans2.get(j));
            j++;
        }
        return ans;
    }
    public void solve(TreeNode root, List<Integer> ls)
    {
        if(root==null)
        {
            return;
        }
        solve(root.left,ls);
        ls.add(root.val);
        solve(root.right,ls);
    }

}