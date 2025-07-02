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
        if (head == null || left == right) return head;

        // Step 1: Create a dummy node to handle edge cases
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Step 2: Move `prev` to the node before the 'left' position
        ListNode prev = dummy;
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        // Step 3: Set pointers for reversal
        ListNode reverseStart = prev.next;       // The first node to reverse
        ListNode curr = reverseStart.next;

        // Step 4: Use your classic reversal logic inside the bounds
        for (int i = 0; i < right - left; i++) {
            ListNode nextNode = curr.next;

            // Reverse pointers
            curr.next = prev.next;
            prev.next = curr;
            reverseStart.next = nextNode;

            // Move forward
            curr = nextNode;
        }

        return dummy.next;
    }
}
