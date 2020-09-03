class linkedlist{
    static class Node{
        int data=0;
        Node next=null;
        Node(int data){
            this.data=data;
        }
    }
    //@Override is to ensure that we have successfully able to override... by chance we write tostring().. @Override will show an error.
    //if we don't write override it will compile and not show any error..
    @Override
    public String toString(){
        Node temp = this.head;
        String str = "[";
        while(temp!=null){
            if(temp.next==null)
            str += temp.data;
            else
            str += temp.data +",";
            temp = temp.next;
        }
        str+= "]";
        return str;
    }
    private Node head=null;
    private Node tail=null;
    private static int size=0;
    public static int size(){
        return size;
    }
    public static boolean isempty(){
        return (size==0)?true:false;
    }
    //add========================================
    private void addFirstNode(Node node){
        if(size==0){
            this.head=this.tail=node;
        }else{
        node.next=head;
        this.head=node;
        }
        this.size++;
    }
    private void addLastNode(Node node){
        if(size==0){
            this.head=this.tail=node;
        }else{
        tail.next=node;
        tail=node;
        }
        this.size++;
    }
    public void addFirst(int data){
        Node node=new Node(data);
        addFirstNode(node);
    }
    public void addLast(int data){
        Node node=new Node(data);
        addLastNode(node);
    }
    private void addNodeAt(int idx,Node node) throws Exception{
        if(idx == 0) addFirstNode(node);
        else if(idx == this.size) addLastNode(node);
        else{
            Node prev = getNodeAt(idx-1);
            Node forw = prev.next;

            prev.next = node;
            node.next = forw;
            this.size++;
        }
    }
    public void addAt(int idx,int data) throws Exception{
        Node node=new Node(data);
        if(idx == 0) addFirstNode(node);
        else if(idx == this.size-1) addLastNode(node);
        else addNodeAt(idx,node);
    }
    // delete =======================================
    private Node removeNodeFirst() throws Exception{
        Node rem=head;
        if(size==1){
            head=tail=null;
        }else{
            head=head.next;
        }
        rem.next=null;
        this.size--;
        return rem;
    }
    public int removeFirst() throws Exception{
        if(size==0){
             throw new Exception("Empty!");
        }else{
            return removeNodeFirst().data;
        }
    }
    private Node removeNodeLast() throws Exception{
        Node rem=tail;
        if(size==1){
            head=tail=null;
        }else{
            Node secondLastNode = getNodeAt(this.size-2);
            secondLastNode.next = null;
            this.tail = secondLastNode;
        }
        rem.next=null;
        this.size--;
        return rem;
    }
    public int removeLast() throws Exception{
        if(size==0){
            throw new Exception("Empty!");
        }else{
            return removeNodeLast().data;
        }
    }
    private Node removeNodeAt(int idx) throws Exception{
        if(idx==0) return removeNodeFirst();
        else if(idx==this.size-1) return removeNodeLast();
        else{
            Node prev=getNodeAt(idx-1);
            Node rnode=prev.next;
            prev.next=rnode.next;
            rnode.next=null;
            this.size--;
            return rnode;
        }
    }
    public int removeAt(int idx) throws Exception{
        if(idx<0||idx>=this.size){
            throw new Exception("NullPointer");
        }else{
            Node node=removeNodeAt(idx);
            return node.data;
        }
    }
    // Get ==========================================
    public int getFirst() throws Exception{
        if(this.size==0){
            throw new Exception("LinkedListEmpty");
        }
        return this.head.data;
    }

    public int getLast() throws Exception{
        if(this.size==0){
            throw new Exception("LinkedListEmpty");
        }
        return this.tail.data;
    }  
  
    private Node getNodeAt(int idx)  throws Exception{
        Node node=head;
        while(idx-->0){
            node=node.next;
        }
        return node;
    }

    public int getAt(int idx)throws Exception{
        if(idx<0||idx>=this.size){
            throw new Exception("NullPointer");
        }else{
           if(idx == 0) return getFirst();
           else if(idx == this.size-1) return getLast();
           else{
               Node rnode = getNodeAt(idx);
               return rnode.data;
           }
        }
    }

    //https://practice.geeksforgeeks.org/problems/segregate-even-and-odd-nodes-in-a-linked-list/0
    public Node EvenOddByValue(Node head){
        if(head==null||head.next==null) return head;
        Node ohead=new Node(-1);
        Node op=ohead;

        Node ehead=new Node(-1);
        Node ep=ehead;
        
        Node curr=head;

        while(curr!=null){
            if(curr.val%2==0){
                ep.next=curr;
                ep=ep.next;
            }else{
                op.next=curr;
                op=op.next;
            }
            curr=curr.next;
        }
        ep.next=null;
        op.next=null;

        ep.next=ohead.next;
        return ehead.next;

    }
}