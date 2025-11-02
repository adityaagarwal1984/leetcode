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
        if (head == null || head.next == null || k == 0) return head;

        // Step 1: Find the length of the list and get the tail
        ListNode temp = head;
        int len = 1;
        while (temp.next != null) {
            len++;
            temp = temp.next;
        }

        // Step 2: Connect tail to head to make it circular
        temp.next = head;

        // Step 3: Find the new head position (len - k % len - 1) moves from start
        k = k % len;
        int moves = len - k;

        // Step 4: Move to the new tail
        ListNode newTail = head;
        for (int i = 1; i < moves; i++) {
            newTail = newTail.next;
        }

        // Step 5: Set new head and break the circle
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}
