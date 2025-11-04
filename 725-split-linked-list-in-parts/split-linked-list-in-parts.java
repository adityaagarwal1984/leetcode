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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] result = new ListNode[k];

        // Step 1: Count total length of the list
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }

        // Step 2: Determine size of each part
        int baseSize = length / k; // minimum size for each part
        int extra = length % k;    // first 'extra' parts will get +1 node

        // Step 3: Split the list
        temp = head;
        for (int i = 0; i < k && temp != null; i++) {
            result[i] = temp; // mark start of current part

            // Determine the correct size of current part
            int currentPartSize = baseSize + (i < extra ? 1 : 0);

            // Move to the last node of this part
            for (int j = 1; j < currentPartSize; j++) {
                temp = temp.next;
            }

            // Disconnect current part from next
            ListNode nextPartHead = temp.next;
            temp.next = null;
            temp = nextPartHead;
        }

        return result;
    }
}
