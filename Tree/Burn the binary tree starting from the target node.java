//https://www.geeksforgeeks.org/burn-the-binary-tree-starting-from-the-target-node/   
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
