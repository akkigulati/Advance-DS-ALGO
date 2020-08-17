//https://leetcode.com/problems/binary-tree-maximum-path-sum/
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
    public int maxPathSum(TreeNode root) {
        maxPathSum_(root);
        return NTNRes;
    }
    //nodetonode result
    int NTNRes=-(int)1e8;
    public int maxPathSum_(TreeNode root){
        if(root==null){
            return -(int)1e8;
            //return 0;
        }
        int lChildmax=maxPathSum_(root.left);
        int rChildmax=maxPathSum_(root.right);
        int max_=Math.max(lChildmax,rChildmax)+root.val;
        NTNRes=Math.max(Math.max(NTNRes,root.val),Math.max(max_,lChildmax+rChildmax+root.val));
        return Math.max(root.val,max_);
    }
}
