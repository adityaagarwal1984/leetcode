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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null || head.next==null)
        return head;
        ListNode dummy= new ListNode(0);
        ListNode node=dummy;
        node.next=head;
        ListNode ri=head;
        while(right>0)
        {
            ri=ri.next;
            right--;
        }
        while(left-1>0)
        {
            node=node.next;
            left--;
        }
        ListNode prev=null;
        ListNode curr=node.next;
        while(curr!=ri)
        {
            ListNode next= curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        node.next=prev;
        while(node.next!=null)
        {
            node=node.next;
        }
        node.next=ri;
        return dummy.next;
        
    }
}