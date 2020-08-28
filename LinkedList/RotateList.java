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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||head.next==null||k==0) return head;
       int size=0;
        ListNode temp=head;
        while(temp!=null){
            temp=temp.next;
            size++;
        }
        k=k%size;
        ListNode c1=head;
        ListNode c2=head;
        while(k-->0){
            c2=c2.next;
        }
        while(c2.next!=null){
            c2=c2.next;
            c1=c1.next;
        }
        c2.next=head;
        head=c1.next;
        c1.next=null;
        return head;
    }
}
