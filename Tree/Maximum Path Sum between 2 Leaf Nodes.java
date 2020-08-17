//https://practice.geeksforgeeks.org/problems/maximum-path-sum/1  
class Tree
{   public int leaftoleafAns=-(int)1e8;
    int maxPathSum(Node root){
    leaftoleafsum(root);
    return leaftoleafAns;
        
    } 
     int leaftoleafsum(Node root)
         {   if(root==null){
        return -(int)1e8;
    }
    if(root.left==null&&root.right==null){
        return root.data;
    }
        int lmax=leaftoleafsum(root.left);
        int rmax=leaftoleafsum(root.right);
        if(root.left!=null&&root.right!=null)
        leaftoleafAns=Math.max(leaftoleafAns,lmax+rmax+root.data);
        
        return Math.max(lmax,rmax)+root.data;
     }
}
