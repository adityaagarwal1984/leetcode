/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> ans= new ArrayList<>();
        if(root==null)
        return ans;
        order(root,ans);
        return ans;
    }
    public void order(Node root,List<Integer> ls)
    {
        if(root==null)
        return;
        ls.add(root.val);
        for(Node node:root.children)
        {
            order(node,ls);
        }
    }
}