/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode adi= head;
        ListNode bg=head;
        while(bg!=null && bg.next!=null)
        {
             bg=bg.next.next;
            adi=adi.next;
            if(bg==adi)
        return true;
           
        }
        
        
        return false;
        
    }
}