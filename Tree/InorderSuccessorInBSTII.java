  //Leetcode 510.
    /*
    // Definition for a Node.
    class Node {
       public int val;
       public Node left;
       public Node right;
       public Node parent;
    };
    */

    public Node inorderSuccessor(Node node) {
        Node curr = node;
        Node succ = null;
        if(curr.right!=null){
            succ = curr.right;
            while(succ.left != null) succ=succ.left;
            
            return succ;
        }
        
        Node prev = null;
        while(curr.parent!=null){
            prev = curr;
            curr = curr.parent;
            if(curr.left == prev) return curr;
        }
        
        return succ;
    }
