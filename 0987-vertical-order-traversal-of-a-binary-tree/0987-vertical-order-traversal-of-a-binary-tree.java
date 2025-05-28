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
    //col->[level,list]
    TreeMap<Integer,TreeMap<Integer,List<Integer>>> map= new TreeMap<>();
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        
        List<List<Integer>> ans= new ArrayList<>();
        if(root==null)
        return ans;

        dfs(root,0,0);
        for(Map.Entry<Integer,TreeMap<Integer,List<Integer>>> entry : map.entrySet())
        {
            TreeMap<Integer,List<Integer>> submap= entry.getValue();
            List<Integer> list= new ArrayList<>();
            for(Map.Entry<Integer,List<Integer>> subsub : submap.entrySet())
            {
                List<Integer> slist= subsub.getValue();
                 Collections.sort(slist);
                list.addAll(slist);
               
            }
            ans.add(list);
        }
        return ans;

    }
    public void dfs(TreeNode root, int col,int level)
    {
        if(root==null)
        return;
        // insert col
        if(!map.containsKey(col))
        map.put(col, new TreeMap<>());
        //add  level
        if(!map.get(col).containsKey(level))
        map.get(col).put(level, new ArrayList<>());
        // add data
        map.get(col).get(level).add(root.val);
        dfs(root.left,col-1,level+1);
         dfs(root.right,col+1,level+1);
    }
}