/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null) return null;
        int lenA=0;
        int lenB=0;
        ListNode tempA=headA;
        ListNode tempB=headB;
        while(headA!=null) {
            lenA++;
            headA=headA.next;
        }
        while(headB!=null){
            lenB++;
            headB=headB.next;
        }

        
        if(lenA>lenB){
            int len=lenA-lenB;
            while(len-->0){
                tempA=tempA.next;
            }
        }else{
            int len=lenB-lenA;
            while(len-->0){
                tempB=tempB.next;
            }
        }
        while(tempA!=null&&tempB!=null){
            if(tempA==tempB) return tempA;
            tempA=tempA.next;
            tempB=tempB.next;
        }
        return null;
    }
}
