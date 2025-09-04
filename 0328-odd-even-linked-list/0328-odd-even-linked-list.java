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
    public ListNode oddEvenList(ListNode head) {
        // Edge case: if the list is empty or has only one node, return it as is
        if (head == null || head.next == null) {
            return head;
        }

        ListNode odd = head;           // Points to the first node (odd index)
        ListNode even = head.next;     // Points to the second node (even index)
        ListNode evenHead = even;      // Stores the head of even nodes to link later

        while (even != null && even.next != null) {
            odd.next = even.next;      // Connecting odd nodes
            odd = odd.next;            // Move to next odd node
            
            even.next = odd.next;      // Connecting even nodes
            even = even.next;          // Move to next even node
        }

        odd.next = evenHead; // Append even nodes after odd nodes
        return head;
    }
}

