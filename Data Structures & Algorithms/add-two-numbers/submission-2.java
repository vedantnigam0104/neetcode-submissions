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
        int sum=0;

        int carry=0;

        ListNode node1=l1;

        ListNode node2=l2;

        ListNode res=new ListNode(0);

        ListNode curr=res;

        while(node1!=null || node2!=null || carry!=0)
        {
            int val1=node1!=null?node1.val:0;

            int val2=node2!=null?node2.val:0;

            sum+=val1+val2+carry;

            carry=sum/10;

            sum=sum%10;

            curr.next=new ListNode(sum);

            curr=curr.next;

            sum=0;

            if(node1!=null)
                node1=node1.next;

            if(node2!=null)
                node2=node2.next;    
        }
        return res.next;
    }
}
