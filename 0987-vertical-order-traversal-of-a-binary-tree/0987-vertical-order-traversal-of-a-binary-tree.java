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
 // remember 1 thing in this 
 // TreeMap<Integer,TreeMap<Integer,List<Integer>>> map;
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer,TreeMap<Integer,List<Integer>>> map=
         new TreeMap<>();
         List<List<Integer>> ans= new ArrayList<>();
         fill(root, map,0,0);
        for(TreeMap<Integer,List<Integer>> submap: map.values())
        {
            List<Integer> per_col= new ArrayList<>();
            for(List<Integer> ls: submap.values() )
            {
                Collections.sort(ls);
                for(int num: ls)
                {
                    per_col.add(num);
                }
            }
            ans.add(new ArrayList<>(per_col));

        }
        return ans;
    }
    public void fill(TreeNode root,TreeMap<Integer,TreeMap<Integer,List<Integer>>> map,int row,int col)
    {
        if(root==null)
        return;
        if(!map.containsKey(col))
        map.put(col, new TreeMap());
        if(!map.get(col).containsKey(row))
        map.get(col).put(row,new ArrayList<>());
        map.get(col).get(row).add(root.val);
        fill(root.left,map,row+1,col-1);
        fill(root.right,map,row+1,col+1);


    }
}