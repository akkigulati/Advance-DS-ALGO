/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null) return null;
        if(head.next==null) {
         Node nn=new Node(head.val);
            nn.next=head.next;
            nn.random=head.random;
        }
        
        Node temp=head;
        Node newHead=null;
        while(temp!=null){
            Node nn=new Node(temp.val);
            if(newHead==null){
                newHead=nn;
            }
            nn.next=temp.next;
            temp.next=nn;
            temp=temp.next.next;
        }
        temp=head;
        while(temp!=null&&temp.next!=null){
            if(temp.random==null){
                temp.next.random=null;
            }else{
            temp.next.random=temp.random.next;}
            temp=temp.next.next;
        }
        Node l1=head;
        Node ohead=head.next;
        Node l2=ohead;
        while(l1.next!=null&&l2.next!=null){
            l1.next=l2.next;
            l1=l2.next;
            l2.next=l1.next;
            l2=l1.next;
        }
        
        l1.next=null;
        return ohead;
    }
}
