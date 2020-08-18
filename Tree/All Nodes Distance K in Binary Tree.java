//https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        if(root==null){
            return new ArrayList<>();
        }
        List<TreeNode> path=Nodetoroot(root,target);
        ai=new ArrayList<>();
        
        for(int i=0;i<path.size();i++){
        TreeNode block=null;
            if(i!=0){
                block=path.get(i-1);
            }
            kleveldown(path.get(i),K-i,block);
        }
        
        return ai;
    }
    static List<Integer> ai;
    public static void kleveldown(TreeNode node,int k,TreeNode block){
        if(node==null) return ;
        if(node==block){
            return;
        }
        if(k==0){
            ai.add(node.val);
            return ;
        }
        
        
        kleveldown(node.left,k-1,block);
        kleveldown(node.right,k-1,block);
        
    }
    public List<TreeNode> Nodetoroot(TreeNode root,TreeNode target){
        if(root==null){
            return new ArrayList<>();
        }
        if(root==target){
            List<TreeNode> base=new ArrayList<>();
            base.add(root);
            return base;
        }
        List<TreeNode> Lchild=Nodetoroot(root.left,target);
        if(Lchild.size()!=0){
            Lchild.add(root);
            return Lchild;
        }
        List<TreeNode> Rchild=Nodetoroot(root.right,target);
        if(Rchild.size()!=0){
            Rchild.add(root);
            return Rchild;
        }
        return new ArrayList<>();
    }
}
//optimized O(1) space
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        if(root==null){
            return new ArrayList<>();
        }
        
        ai=new ArrayList<>();
        kfarAway(root,target,K);
        
        
        return ai;
    }
    static List<Integer> ai;
    public static void kleveldown(TreeNode node,int k,TreeNode block){
        if(node==null) return ;
        if(node==block){
            return;
        }
        if(k==0){
            ai.add(node.val);
            return ;
        }
        
        
        kleveldown(node.left,k-1,block);
        kleveldown(node.right,k-1,block);
        
    }
    public int kfarAway(TreeNode root,TreeNode target,int k){
        if(root==null){
            return -1;
        }
        if(root==target){
            kleveldown(root,k,null);
            return 1;
        }
       int ld=kfarAway(root.left,target,k);
        if(ld!=-1){
            kleveldown(root,k-ld,root.left);
                return ld+1;
        }
        int rd=kfarAway(root.right,target,k);
        if(rd!=-1){
            kleveldown(root,k-rd,root.right);
                return rd+1;
        }
        return -1;
    }
}
