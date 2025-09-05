/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null )
        return  null;
        ListNode temp=head;
        int l=0;
        while(temp!=null)
        {
            l++;
            temp=temp.next;
        }
        k=k%l;
        if(k==0 )
        return head;
        // if(k==l)
        // return reverse(head);
        int moves=l-k-1;
        temp=head;
        while(moves>0)
        {
            temp=temp.next;
            moves--;
        }
        ListNode dummy= new ListNode(-1);
        dummy.next=temp.next;
        temp.next=null;
        ListNode node=dummy.next;
        while(node.next!=null)
        {
            node=node.next;
        }
        node.next=head;
        return dummy.next;


        
    }
    public ListNode reverse(ListNode head)
    {
        ListNode prev=null;
        ListNode curr=head;
        while(curr!=null)
        {
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
}