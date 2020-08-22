//Leetcode to see question https://www.lintcode.com/problem/inorder-successor-in-bst/description

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


public class Solution {
    /*
     * @param root: The root of the BST.
     * @param p: You need find the successor node of p.
     * @return: Successor of p.
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
         TreeNode curr=root;
         TreeNode succ=null;
         while(curr!=null){
             if(curr==p){
                 if(curr.right!=null){
                     succ=succ.right;
                     while(succ.next!=null){
                         succ=succ.left;
                     }
                     break;
                 }
             }else if(curr.val<p.val){
                 curr=curr.right;
             }else{
                 succ=curr;
                 curr=curr.left;
                 
             }
         }
         return succ;
    }
}
