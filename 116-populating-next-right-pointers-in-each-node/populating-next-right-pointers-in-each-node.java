/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root==null)
        return root;
        Queue<Node> que= new LinkedList<>();
        que.offer(root);
        while(!que.isEmpty())
        {
            int l=que.size();
            List<Node> ls= new ArrayList<>();
            for(int i=0;i<l;i++)
            {
                Node node=que.poll();
                if(node.left!=null)
                que.offer(node.left);
                if(node.right!=null)
                que.offer(node.right);
                ls.add(node);
            }
           
            
                for(int j=0;j<ls.size()-1;j++)
                {
                    Node node=ls.get(j);
                    Node second=ls.get(j+1);
                    node.next=second;
                }
            


        }
        return root;
    }
}