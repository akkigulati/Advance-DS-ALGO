/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
 public boolean hasCycle(ListNode head) {
    if (head == null || head.next == null) {
        return false;
    }
    ListNode slow = head;
    ListNode fast = head.next;
    while (slow != fast) {
        if (fast == null || fast.next == null) {
            return false;
        }
        slow = slow.next;
        fast = fast.next.next;
    }
    return true;
}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////
public class Solution {
    public boolean hasCycle(ListNode head) {
        while(head!=null){
            if(head.val!=-(int)1e8){
                head.val=-(int)1e8;
                head=head.next;
            }else{
                return true;
            }
        }
        return false;
    }
}
