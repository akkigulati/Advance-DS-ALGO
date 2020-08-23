//https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/submissions/
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
class Solution{
public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0) return null;
        int n = preorder.length;
        return construct(preorder,0,n-1,inorder,0,n-1);
    }
    public TreeNode construct(int[] preorder,int psi,int pei ,int[] inorder,int isi,int iei){
        if(psi > pei) return null;
        int idx = isi;
        while(inorder[idx] != preorder[psi])idx++;
        int len = idx - isi;
        
        TreeNode node = new TreeNode(preorder[psi]);
        node.left = construct(preorder,psi+1,psi+len,inorder,isi,idx-1);
        node.right = construct(preorder,psi+len+1,pei,inorder,idx+1,iei);
        
        return node;
    }
}
