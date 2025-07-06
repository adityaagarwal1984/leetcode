/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        Node temp=head;
        while(temp!=null)
        {
            if(temp.child!=null)
            {
                Node nextnode= temp.next;
                temp.next=flatten(temp.child);
                temp.next.prev=temp;
                temp.child=null;

                Node tail=temp.next;

                while(tail.next!=null)
                tail=tail.next;

                if(nextnode!=null)
                {
                    tail.next=nextnode;
                    nextnode.prev=tail;
                }
            }
            temp=temp.next;
        }
return head;

        
    }
}