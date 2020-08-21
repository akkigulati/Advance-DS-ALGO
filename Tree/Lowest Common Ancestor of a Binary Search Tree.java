//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/submissions/
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;
        
        while(root!=null){
            if(root==p&&root==q){
                return root;
            }else if(root.val<p.val&&root.val<q.val){
                root=root.right;
            }else if(root.val>p.val&&root.val>q.val){
                root=root.left;
            }else{
                return root;
            }
        }
        return root;
    }
}
