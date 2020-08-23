//https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/submissions/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder.length==0) return null;
        int n=postorder.length;
        return buildTree(postorder,0,n-1,inorder,0,n-1);
    }

    public TreeNode buildTree(int[] postorder,int psi,int pei,int[] inorder,int isi,int iei){
        if(psi>pei) return null;
        int idx=isi;
        while(inorder[idx]!=postorder[pei]) idx++;
        int len=idx-isi;
        TreeNode node=new TreeNode(postorder[pei]);
        node.left=buildTree(postorder,psi,psi+len-1,inorder,isi,idx-1);
        node.right=buildTree(postorder,psi+len,pei-1,inorder,idx+1,isi);
        return node;
    }
}
