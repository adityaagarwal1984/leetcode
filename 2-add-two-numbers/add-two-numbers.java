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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry=0;
        ListNode dummy= new ListNode(-1);
        ListNode temp=dummy;
        while(l1!=null && l2!=null)
        {
            int val=carry+l1.val+l2.val;
            int num=val%10;
            carry =val/10;
            ListNode node= new ListNode(num);
            temp.next=node;
            temp=temp.next;
            l1=l1.next;
            l2=l2.next;


        }
        while(l1!=null)
        {
            int val=carry+l1.val;
            int num=val%10;
            carry =val/10;
            ListNode node= new ListNode(num);
            temp.next=node;
            temp=temp.next;
            l1=l1.next;

        }
        while(l2!=null)
        {
            int val=carry+l2.val;
            int num=val%10;
            carry =val/10;
            ListNode node= new ListNode(num);
            temp.next=node;
            temp=temp.next;
            l2=l2.next;

        }
        if(carry==1)
        temp.next= new ListNode(1);
        
return dummy.next;
        
    }
}