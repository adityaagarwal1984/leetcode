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
    public List<List<Integer>> levelOrder(Node root) {
        
        List<List<Integer>> ans= new ArrayList<>();
        if(root==null)
        return ans;
        Queue<Node> que= new LinkedList<>();
        que.offer(root);
        while(!que.isEmpty())
        {
            int l=que.size();
            List<Integer> ls= new ArrayList<>();
            for(int i=0;i<l;i++)
            {
                Node node=que.poll();
                ls.add(node.val);
                if(node.children!=null)
                {
                    for(Node child:node.children)
                    {
                        que.offer(child);
                    }
                }
            }
            ans.add(new ArrayList<>(ls));
        }
        return ans;
    }
}