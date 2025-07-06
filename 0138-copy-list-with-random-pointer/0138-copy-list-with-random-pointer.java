/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node temp=head;
        // adding copy of the node to the right of all the originas nodes
        while(temp!=null)
        {
            Node newnode=new Node(temp.val);
            newnode.next=temp.next;
            temp.next=newnode;
            temp=temp.next.next;

        }
        //adding a random pointer in coiped list
        temp=head;
        while(temp!=null)
        {
            if(temp.random!=null)
            temp.next.random=temp.random.next;
            temp=temp.next.next;
        }
        Node dummy= new Node(-1);
        Node curr=dummy;
        temp=head;
        while(temp!=null)
        {
            curr.next=temp.next;
            curr=curr.next;
            temp.next=temp.next.next;
            temp=temp.next;
        }
        return dummy.next;
    }
}