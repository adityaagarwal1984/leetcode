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
    public ListNode sortList(ListNode head) {
        List<Integer> list= new ArrayList<>();
        ListNode node=head;
        while(node!=null)
        {
            list.add(node.val);
            node=node.next;
        }
        Collections.sort(list);
        ListNode root=head;
        for(int num:list)
        {
            root.val=num;
            root=root.next;
        }
        return head;
    }
}