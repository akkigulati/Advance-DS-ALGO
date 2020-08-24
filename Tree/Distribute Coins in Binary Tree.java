//https://leetcode.com/problems/distribute-coins-in-binary-tree/
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
    int totalCoins=0;
    public int distributeCoins(TreeNode root) {
        
        if(distributeCoins_(root)!=0) return -1;
        return totalCoins;
    }
    public int distributeCoins_(TreeNode root){
        if(root==null) return 0;
        int leftDeficitGain=distributeCoins_(root.left);
        int rightDeficitGain=distributeCoins_(root.right);
        
        totalCoins+=Math.abs(leftDeficitGain)+Math.abs(rightDeficitGain);
        return root.val-1+leftDeficitGain+rightDeficitGain;
    }
}
