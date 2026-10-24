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
    public void reorderList(ListNode head) {
        ListNode curr=head;

        ListNode middle=mid(curr);

        ListNode head2=middle.next;

        middle.next=null;

        ListNode head3=reverse(head2);

        curr=head;

        while(head3!=null)
        {
            ListNode fwd1=curr.next;

            ListNode fwd2=head3.next;

            curr.next=head3;

            head3.next=fwd1;

            curr=fwd1;

            head3=fwd2;
        }
        return;
    }
    ListNode mid(ListNode head)
    {
        ListNode fast=head;

        ListNode slow=head;

        while(fast!=null && fast.next!=null)
        {
            fast=fast.next.next;

            slow=slow.next;
        }
        return slow;
    }

    ListNode reverse(ListNode head)
    {
        ListNode curr=head;

        ListNode prev=null;

        while(curr!=null)
        {
            ListNode fwd=curr.next;

            curr.next=prev;

            prev=curr;

            curr=fwd;
        }
        return prev;
    }
}
