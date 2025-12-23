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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums.length==0)
        return null;
        TreeNode root=find(nums,0,nums.length-1);
        return root;
    }
    public TreeNode find(int a[],int l,int r)
    {
        if(l>r)
        return null;
        int i=maxi(a,l,r);
        TreeNode root=new TreeNode(a[i]);
        root.left=find(a,l,i-1);
        root.right=find(a,i+1,r);
        return root;

    }
    public int maxi(int arr[],int l,int r)
    {
        int max=-1;
        int ans=-1;
        for(int i=l;i<=r;i++)
        {
            if(arr[i]>max)
            {
                max=arr[i];
                ans=i;
            }
        }
        return ans;
    }

}