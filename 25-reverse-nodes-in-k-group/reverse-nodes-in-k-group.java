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
 class Solution{
public ListNode reverseKGroup(ListNode head, int k) {
    // Step 1: Check if we have at least k nodes left
    ListNode node = head;
    for (int i = 0; i < k; i++) {
        if (node == null) return head; // less than k nodes, don't reverse
        node = node.next;
    }

    // Step 2: Reverse first k nodes
    ListNode newHead = reverse(head, k);

    // Step 3: Recursively call for the next part
    head.next = reverseKGroup(node, k);

    return newHead;
}

private ListNode reverse(ListNode head, int k) {
    ListNode prev = null;
    ListNode curr = head;
    while (k-- > 0) {
        ListNode next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
    }
    return prev;
}

 }    

                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                

        
   