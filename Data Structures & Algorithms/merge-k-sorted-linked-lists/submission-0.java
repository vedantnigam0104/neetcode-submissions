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
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> li=new ArrayList<>();

        for(int i=0;i<lists.length;i++)
        {
            ListNode curr=lists[i];

            while(curr!=null)
            {
                li.add(curr.val);

                curr=curr.next;
            }
        }
        Collections.sort(li);

        ListNode res=new ListNode(0);

        ListNode c=res;

        for(int i=0;i<li.size();i++)
        {
            c.next=new ListNode(li.get(i));

            c=c.next;
        }
        return res.next;
    }
}
