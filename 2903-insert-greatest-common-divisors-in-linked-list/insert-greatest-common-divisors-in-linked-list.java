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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode dummy=new ListNode(-1);
        
        ListNode temp=head;
        dummy.next=temp;
        while(temp.next!=null)
        {
            ListNode t=temp.next;
            int g=gcd(temp.val,temp.next.val);
            ListNode add= new ListNode(g);
            temp.next=add;
            add.next=t;
            temp=temp.next.next;
        }
        return dummy.next;

        
    }
    public int gcd(int a,int b)
    {
        int g=1;
        for(int i=1;i<=Math.min(a,b);i++)
        {
            if(a%i==0 && b%i==0)
            g=i;
        }
        return g;
    }
}