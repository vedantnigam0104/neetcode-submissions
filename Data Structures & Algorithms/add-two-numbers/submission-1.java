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
    public ListNode addTwoNumbers(ListNode c1, ListNode c2) {
        ListNode res=new ListNode(0);

        ListNode curr=res;

        int s=0;

        int carry=0;

        while(c1!=null || c2!=null || carry!=0)
        {
            int sum1=(c1==null)?0:c1.val;

            int sum2=(c2==null)?0:c2.val;

            s=sum1+sum2+carry;

            carry=s/10;

            int t=s%10;

            curr.next=new ListNode(t);

            curr=curr.next;

            if(c1!=null)
                c1=c1.next;

            if(c2!=null)
                c2=c2.next;    
        }
        return res.next;
    }
}
