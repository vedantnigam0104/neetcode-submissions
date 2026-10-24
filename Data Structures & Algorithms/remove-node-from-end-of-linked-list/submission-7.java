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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len=0;

        if(head==null)
            return null; 

        ListNode curr=head;

        while(curr!=null)
        {
            len++;

            curr=curr.next;
        }

        if(n==len)
            return head.next;

        int pos=len-n;    

        int p=0;

        curr=head;

        while(p!=pos-1)
        {
            curr=curr.next;

            p++;
        }

        curr.next=curr.next.next;

        return head;    
    }
}
