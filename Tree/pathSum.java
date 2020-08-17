//leet 112 https://leetcode.com/problems/path-sum/

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
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null){
            return false;
        }
        if(root.left==null&&root.right==null){
            if(sum-root.val==0){
                return true;
            }
            return false;
        }
        boolean ans=hasPathSum(root.left,sum-root.val);
        ans=ans||hasPathSum(root.right,sum-root.val);
        if(ans) return true;
        
        return false;
    }
}