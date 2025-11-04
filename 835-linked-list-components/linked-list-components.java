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
    public int numComponents(ListNode head, int[] nums) {
        int c=0;
        ListNode temp=head;
        Set<Integer> set= new HashSet<>();
        for(int num:nums)
        set.add(num);
        while(temp!=null)
        {
            if(!set.contains(temp.val))
            temp=temp.next;
            else
            {
                c++;
                while(temp!=null && set.contains(temp.val) )
                {
                    temp=temp.next;
                }
            }
        }
        return c;
        
    }
}