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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head==null||head.next==null) return head;
        if(n==m) return head;
        ListNode temp=head;
        int len=0;
        ListNode prev1=null;
        ListNode prev2=null;
        ListNode Start=null;
        ListNode end=null;
        while(len!=n){
            
            len++;
            if(len==m){
                prev1=prev2;
                Start=temp;
            }
            if(len==n){
                end=temp;
            }
            prev2=temp;
            temp=temp.next;
        }
        prev2=end.next;
        
        
        end.next=null;
        if(prev1!=null){
        prev1.next=null;
        prev1.next=reverseList(Start);
        }else{
            head=reverseList(Start);
        }
        Start.next=prev2;
        
        return head;
        
    }
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode prev=null;
        ListNode curr=head;
        ListNode forward=head;
        while(curr!=null){
            forward=curr.next;//back up
            curr.next=prev;//connection
            prev=curr;//movements
            curr=forward;
        }
        return prev;
    }
}
