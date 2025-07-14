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
    public int getDecimalValue(ListNode head) {
        ListNode temp= head;
        int l=0;
        while(temp!=null)
        {
            temp=temp.next;
            l++;
        }
         temp=head;
        int d=0;
        while(temp!=null)
        {
            d+=temp.val*(Math.pow(2,l-1));
            l--;
            temp=temp.next;
        }
        return d;
        
    }
}