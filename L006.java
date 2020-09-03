class L006{
    public static void main(String[] args){
        solver();
    }
   static class Node{
        Node left;
        int data;
        Node right;
        Node(int data){
            this.data = data;
        }
        Node(int d,Node l,Node r){
            data=d;
            left=l;
            right=r;
        }
    }
    public static void solver(){
        int arr[]={10,20,30,40,50,60,70,80};
        Node root=constructBST(arr,0,arr.length-1);
        display(root);
        // System.out.println(find(root,30));
        // display(BSTUsingPreOrder(arr,-(int)1e8,(int)1e8));
        // System.out.println(BSTPreOrderHeight(arr,-(int)1e8,(int)1e8));
        // PredSucc(root,40);
        addNode(root,55);
        display(root);
        removeData(root,55);
        display(root);
    }
    public static Node constructBST(int arr[],int s,int e){
        if(s>e) return null;
        int mid=((s+e)>>>1);
        Node root=new Node(arr[mid],null,null);
        root.left=constructBST(arr,s,mid-1);
        root.right=constructBST(arr,mid+1,e);
        return root;
    }
    public static void display(Node node){
        if(node==null) return;
        StringBuilder sb = new StringBuilder();
        
        sb.append(node.left!=null?node.left.data+"" : ".");
        sb.append(" <- " + node.data + " -> ");
        sb.append(node.right!=null?node.right.data+"" : ".");

        // System.out.println(sb.toString());
        display(node.left);
        System.out.println(node.data);
        display(node.right);

    }
    public static int minimum(Node node){
        Node curr = node;

        while(curr.left != null)
            curr=curr.left;

        return curr.data;
    }

    public static int maximum(Node node){
        Node curr = node;

        while(curr.right != null)
            curr=curr.right;

        return curr.data;
    }

    public static boolean find(Node node,int data){
        if(node ==null) return false;

        while(node!=null){
            if(node.data==data) return true;
            else if(node.data<data){
                node=node.right;
            }else{
                node=node.left;
            }
        }
        return false;
    }

    static int idx = 0;
    public static Node BSTUsingPreOrder(int[] arr,int lRange, int rRange){
        if(idx >= arr.length || arr[idx] < lRange  ||  arr[idx] > rRange) return null;

        Node node = new Node(arr[idx++]);

        node.left = BSTUsingPreOrder(arr,lRange, node.data);
        node.right = BSTUsingPreOrder(arr,node.data,rRange);

        return node;
    }

    public static int BSTPreOrderHeight(int[] arr,int lRange, int rRange){
        if(idx >= arr.length || arr[idx] < lRange  ||  arr[idx] > rRange) return -1;

        int ele = arr[idx++];
        int lh = BSTPreOrderHeight(arr,lRange, ele);
        int rh = BSTPreOrderHeight(arr,ele,rRange);

        return Math.max(lh,rh)+1;
    }
    public static void PredSucc(Node node,int data){
        Node curr = node;
        Node pred =null,succ = null;
        while(curr != null){

            if(curr.data == data){
                if(curr.left != null){
                    pred = curr.left;
                    while(pred.right != null ){
                        pred =pred.right;
                    }
                }
                if(curr.right != null){
                    succ = curr.right;
                    while(succ.left != null ){
                        succ =succ.left;
                    }
                }
                break;
            }else if(curr.data < data){
                pred = curr;
                curr = curr.right;
            }else{
                succ = curr;
                curr = curr.left;
            }
        }
        System.out.println(pred.data);
        System.out.println(succ.data);
    }
    public static Node addNode(Node node,int data){
        if(node == null) return new Node(data);
        if(data < node.data) node.left = addNode(node.left,data);
        else node.right = addNode(node.right,data);

        return node;
    }

    public static Node removeData(Node node,int data){
        if(node == null) return null;

        if(data < node.data) node.left = removeData(node.left,data);
        else if(data > node.data) node.right = removeData(node.right,data);
        else{
            if(node.left == null || node.right == null) return  node.left != null? node.left: node.right;

            int minEle = minimum(node.right);
            node.data = minEle;

            node.right = removeData(node.right,minEle);
        }

        return node;
    }

}