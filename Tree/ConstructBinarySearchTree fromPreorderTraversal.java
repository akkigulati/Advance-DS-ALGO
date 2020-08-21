//https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/submissions/
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
    public TreeNode bstFromPreorder(int[] preorder) {
     // if(preorder.length==0) return null;
     return preorderToBST(preorder,-(int)1e8,(int)1e8);
    }
     int idx=0;
    public  TreeNode preorderToBST(int[] preorder,int lrange,int rrange){
        if(idx>=preorder.length||preorder[idx]<lrange||preorder[idx]>rrange) return null;
        
        TreeNode root=new TreeNode(preorder[idx++],null,null);
        root.left=preorderToBST(preorder,lrange,root.val);
        root.right=preorderToBST(preorder,root.val,rrange);
        
        return root;
    }
}
