class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while (head != null) {
            if (!set.contains(head.val)) {
                temp.next = new ListNode(head.val);
                temp = temp.next;
            }
            head = head.next;
        }
        return dummy.next;
    }
}
