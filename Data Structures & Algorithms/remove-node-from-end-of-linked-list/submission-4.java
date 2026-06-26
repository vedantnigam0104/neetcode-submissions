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
    public ListNode removeNthFromEnd(ListNode head, int k) {
        int n=0;

        ListNode curr=head;

        if(head==null || head.next==null)
            return null;

        while(curr!=null)
        {
            n++;

            curr=curr.next;
        }

        int ind=n-k;

        int i=1;

        if(n==k)
        {
            head=head.next;

            return head;
        }

        curr=head;

        while(curr!=null && i!=ind)
        {
            curr=curr.next;

            i++;
        }
        if(curr.next!=null && curr.next.next!=null)
            curr.next=curr.next.next;
        else
            curr.next=null;    

        return head;
    }
}
