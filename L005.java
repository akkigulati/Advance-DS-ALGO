import java.util.*;
class L005{

    public static void main(String[] args){
        solve();
    }

    public static class Node{
        int data = 0;
        Node left = null;
        Node right = null;

        Node(int data){
            this.data = data;
        }
    }

    //Basic.==================================================================================

    static int idx = 0;
    public static Node constructTree(int[] arr){
        if(idx==arr.length || arr[idx]==-1){
            idx++;
            return null;
        }

        Node node=new Node(arr[idx++]);

        node.left = constructTree(arr);
        node.right = constructTree(arr);

        return node;
    }

    public static void display(Node node){
        if(node==null) return;
        StringBuilder sb = new StringBuilder();
        
        sb.append(node.left!=null?node.left.data+"" : ".");
        sb.append(" <- " + node.data + " -> ");
        sb.append(node.right!=null?node.right.data+"" : ".");

        System.out.println(sb.toString());

        display(node.left);
        display(node.right);
    }

    public static int size(Node node){
        return node==null? 0 : size(node.left) + size(node.right) + 1; 
    }

    public static int height(Node node){
        return node==null? -1 : Math.max(height(node.left) , height(node.right)) + 1; 
    }

    public static void preOrder(Node node){
        if(node == null) return ;

        System.out.print(node.data);
        preOrder(node.left);
        preOrder(node.right);
    }

    public static void InOrder(Node node){
        if(node == null) return ;

        InOrder(node.left);
        System.out.print(node.data);
        InOrder(node.right);
    }

    public static void postOrder(Node node){
        if(node == null) return ;

        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data);
    }

    // Set1.===========================================================================

    public static int diameter(Node node){
        if(node==null) return 0;

        int ld = diameter(node.left);
        int rd = diameter(node.right);
        
        int lh = height(node.left);
        int rh = height(node.right);

        return Math.max(Math.max(ld,rd),lh+rh+2);
    }
    
    // d, h
    public static int[] diameter_02(Node node){
        if(node==null) return new int[]{0,-1};
        
        int[] lr = diameter_02(node.left);   // left result
        int[] rr = diameter_02(node.right);  // right result

        int dia = Math.max(Math.max(lr[0],rr[0]), lr[1] + rr[1] + 2);
        int height = Math.max(lr[1],rr[1]) + 1;
       
        return new int[]{dia , height};
    }

    
    public static int diameter_03(Node node,int[] res){
        if(node==null) return -1;
        
        int lh = diameter_03(node.left,res);   // left result
        int rh = diameter_03(node.right,res);  // right result

        res[0] = Math.max(res[0],lh + rh + 2);

        return Math.max(lh,rh) + 1;
    }

    public static void diameter(){
        int[] res=new int[1];
        
    }

    // https://www.geeksforgeeks.org/find-maximum-path-sum-two-leaves-binary-tree/

    public int LeafToLeafAns = -(int)1e8;
    public int leafToLeafSum_(Node node){
        if(node == null) return -(int)1e8;
        if(node.left == null && node.right == null) return node.data;

        int lMax = leafToLeafSum_(node.left); 
        int rMax = leafToLeafSum_(node.right);
        
        if(node.left != null && node.right != null){
            LeafToLeafAns = Math.max(LeafToLeafAns, lMax + node.data +rMax);
        }

        return Math.max(lMax,rMax) + node.data;
    }

    int maxPathSum(Node root)
    { 
        leafToLeafSum_(root);
        return LeafToLeafAns;
    } 
    public static void solve(){

        int[] arr={10,20,40,-1,-1,50,80,-1,-1,90,-1,-1,30,60,100,-1,-1,-1,70,110,-1,-1,120,-1,-1};
        Node root = constructTree(arr);
        // display(root);
        // System.out.println(kleveldown(root,3));
        // int minMax[]=new int[2];
        // width(root,0,minMax);
        // System.out.println("Width is"+(minMax[1]-minMax[0]));
        // burnTreeTarget(root,60);
        // burnTreeTarget_(root,60);

    }

    //set 2

    // width of the tree..
    public static void width(Node node,int level,int[] minmax){
        if(node==null) return ;
        //min
        minmax[0]=Math.min(level,minmax[0]);
        //max
        minmax[1]=Math.max(level,minmax[1]);
        
        width(node.left,level-1,minmax);
        width(node.right,level+1,minmax);
    }
    //k levels down
    public static int kleveldown(Node node,int k){
        if(node==null) return 0;
        if(k==0){
            System.out.println(node.data);
            return 1;
        }
        int count =0;
        count+=kleveldown(node.left,k-1)+kleveldown(node.right,k-1);
        return count;
    }
    //gfg => burn the tree starting target node..

    public static void burnTreeTarget(Node node,int target){
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        target(node,target,ans);
        System.out.println(ans);
    }
    public static void kleveldownBurn(Node node,int k,Node block,ArrayList<ArrayList<Integer>> ans){
        if(node==null) return ;
        if(node==block){
            return;
        }
        if(ans.size()<=k){
            ans.add(new ArrayList<>());
        }
        ArrayList<Integer> ai=ans.get(k);
        ai.add(node.data);
        kleveldownBurn(node.left,k+1,block,ans);
        kleveldownBurn(node.right,k+1,block,ans);
        
    }
    public static int target(Node node,int target,ArrayList<ArrayList<Integer>> ans){
        if(node ==null){
            return -1;
        }
        if(node.data==target){
            kleveldownBurn(node,0,null,ans);
            return 1;
        }
        int lchild=target(node.left,target,ans);
        if(lchild!=-1){
            kleveldownBurn(node,lchild,node.left,ans);
            return lchild+1;
        }
        int rchild=target(node.right,target,ans);
        if(rchild!=-1){
            kleveldownBurn(node,rchild,node.right,ans);
            return rchild+1;
        }
        return -1;
    }
    //without block node
    public static void burnTreeTarget_(Node node,int target){
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        target_(node,target,ans);
        System.out.println(ans);
    }
    public static void kleveldownBurn_(Node node,int k,ArrayList<ArrayList<Integer>> ans){
        if(node==null) return ;
        if(ans.size()<=k){
            ans.add(new ArrayList<>());
        }
        ArrayList<Integer> ai=ans.get(k);
        ai.add(node.data);
        kleveldownBurn_(node.left,k+1,ans);
        kleveldownBurn_(node.right,k+1,ans);
        
    }
    public static int target_(Node node,int target,ArrayList<ArrayList<Integer>> ans){
        if(node ==null){
            return -1;
        }
        if(node.data==target){
            kleveldownBurn_(node,0,ans);
            return 1;
        }
        int lchild=target(node.left,target,ans);
        if(lchild!=-1){
            if(ans.size()<=lchild) ans.add(new ArrayList<>());

            ans.get(lchild).add(node.data);
            kleveldownBurn_(node.right,lchild+1,ans);
            return lchild+1;
        }
        int rchild=target(node.right,target,ans);
        if(rchild!=-1){
            if(ans.size()<=rchild) ans.add(new ArrayList<>());
            ans.get(rchild).add(node.data);
            
            kleveldownBurn_(node.left,rchild+1,ans);
            return rchild+1;
        }
        return -1;
    }
}