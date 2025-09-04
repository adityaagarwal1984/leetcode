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
    public ListNode deleteMiddle(ListNode head) {
        if(head==null || head.next==null)
        return null;

        int l=0;
        ListNode node=head;
        while(node!=null)
        {
            l++;
            node=node.next;
        }
        int pos=l/2;
        ListNode n=head;
        for(int i=1;i<pos;i++)
        {
            n=n.next;
        }
        n.next=n.next.next;
        return head;
        
    }
}