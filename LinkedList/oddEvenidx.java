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
    public ListNode oddEvenList(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode ohead=head.next;
        ListNode l1=head;
        ListNode l2=ohead;
        while(l1.next!=null && l2.next!=null){
            l1.next=l2.next;
            l1=l2.next;
            l2.next=l1.next;
            l2=l1.next;
        }
        l1.next=ohead;
        return head;
    }
}
